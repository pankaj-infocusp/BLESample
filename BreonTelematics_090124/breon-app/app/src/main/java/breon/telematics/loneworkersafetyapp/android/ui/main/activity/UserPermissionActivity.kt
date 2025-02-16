package breon.telematics.loneworkersafetyapp.android.ui.main.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import breon.telematics.loneworkersafetyapp.android.R
import breon.telematics.loneworkersafetyapp.android.databinding.ActivityUserPermissionBinding
import breon.telematics.loneworkersafetyapp.android.ui.login.LoginActivity
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants
import breon.telematics.loneworkersafetyapp.android.utils.AppConstants.IS_LOGGED_IN
import breon.telematics.loneworkersafetyapp.android.utils.CurrentStatus
import breon.telematics.loneworkersafetyapp.android.utils.createAlertDialog
import breon.telematics.loneworkersafetyapp.android.utils.permissions

class UserPermissionActivity : AppCompatActivity() {

    private var _binding: ActivityUserPermissionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(
            this, R.layout.activity_user_permission
        )

        initToolbar()
        initClickEvent()
    }

    private fun initToolbar() {
        binding.appToolbar.ivBackIcon.isVisible = false
        binding.appToolbar.tvTitle.text = getString(
            R.string.app_name
        )
    }

    private fun initClickEvent() {
        binding.btnAgree.setOnClickListener {
            if (isLocationPermissionGranted()) {
                startActivity(
                    Intent(
                        this@UserPermissionActivity,
                        LoginActivity::class.java
                    )
                )
                finish()
            } else {
                userConsentDialog()
            }
        }
    }

    private fun isLocationPermissionGranted(): Boolean {
        return permissions.all {
            ActivityCompat.checkSelfPermission(
                this@UserPermissionActivity,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun userConsentDialog() {
        createAlertDialog(
            context = this@UserPermissionActivity,
            title = getString(R.string.user_consent_title),
            message = getString(R.string.user_consent_desc),
            positiveBtnText = "Ok",
            negativeBtnText = "Cancel",
            onPositiveBtnClick = {
                requestMultiplePermissionsLauncher.launch(permissions)
            },
            onNegativeBtnClick = {
                Toast.makeText(this@UserPermissionActivity, "Location service is mandatory to keep user safety. Please allow it from settings.", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private val requestMultiplePermissionsLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val allPermissionsGranted = permissions.all { it.value }
            if (allPermissionsGranted) {
                checkAndRequestNotificationPermission()
            } else {
                // Permission denied, handle accordingly (show explanation, disable functionality, etc.)
                showPermissionDeniedDialog()
            }
        }

    private fun showPermissionDeniedDialog() {
        createAlertDialog(
            context = this@UserPermissionActivity,
            title = getString(R.string.permission_denied),
            message = getString(R.string.permission_desc),
            positiveBtnText = "Ok",
            negativeBtnText = "Cancel",
            onPositiveBtnClick = {
                requestMultiplePermissionsLauncher.launch(permissions)
            },
            onNegativeBtnClick = {

            }
        )
    }

    private fun checkAndRequestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.POST_NOTIFICATIONS)) {
                PackageManager.PERMISSION_GRANTED -> {
                    startActivity(
                        Intent(
                            this@UserPermissionActivity,
                            LoginActivity::class.java
                        )
                    )
                    finish()
                }

                else -> {
                    notificationPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        } else {
            startActivity(
                Intent(
                    this@UserPermissionActivity,
                    LoginActivity::class.java
                )
            )
            finish()
        }
    }

    // we need notification permission to be able to display a notification for the foreground service
    private val notificationPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                startActivity(
                    Intent(
                        this@UserPermissionActivity,
                        LoginActivity::class.java
                    )
                )
                finish()
            } else {
                showNotificationPermissionDialog()
            }
            // if permission was denied, the service can still run only the notification won't be visible
        }

    private fun showNotificationPermissionDialog() {
        createAlertDialog(
            context = this@UserPermissionActivity,
            title = getString(R.string.notification_permission_title),
            message = getString(R.string.notification_permission_desc),
            positiveBtnText = "Ok",
            negativeBtnText = "Cancel",
            onPositiveBtnClick = {
                val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                startActivity(intent)
            },
            onNegativeBtnClick = {
                Toast.makeText(this@UserPermissionActivity, "Notification permission is mandatory. Please allow it from settings.", Toast.LENGTH_SHORT).show()
            }
        )
    }
}