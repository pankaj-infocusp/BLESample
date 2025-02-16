package breon.telematics.loneworkersafetyapp.android.ui.main.take2form

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import breon.telematics.loneworkersafetyapp.android.databinding.RowFormActionsBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.request.Take2FormActionsModel

class Take2FormActionsAdapter(private val mList: List<Take2FormActionsModel>) :
	RecyclerView.Adapter<Take2FormActionsAdapter.ViewHolder>() {

	private var selectedPosition: Int = RecyclerView.NO_POSITION
	private val taskActions = ArrayList<String>()

	// create new views
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding =
			RowFormActionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ViewHolder(binding)
	}

	// binds the list items to a view
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		with(holder) {
			with(mList[position]) {
				binding.cbAction.text = action
				binding.cbAction.isChecked = position == selectedPosition
				binding.cbAction.setOnClickListener {
					if (taskActions.contains(action)) {
						taskActions.remove(action)
					} else {
						taskActions.add(action)
					}

//					val previousPosition = selectedPosition
//					selectedPosition = position
//					notifyItemChanged(previousPosition)
//					notifyItemChanged(selectedPosition)
				}
			}
		}
	}

	// return the number of the items in the list
	override fun getItemCount(): Int {
		return mList.size
	}

	fun getSelectedActions(): ArrayList<String> {
		return taskActions
	}

	// Holds the views for adding it to image and text
	class ViewHolder(val binding: RowFormActionsBinding) : RecyclerView.ViewHolder(binding.root)
}