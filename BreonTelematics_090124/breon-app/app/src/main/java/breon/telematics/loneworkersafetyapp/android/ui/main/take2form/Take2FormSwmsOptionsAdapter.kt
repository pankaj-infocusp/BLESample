package breon.telematics.loneworkersafetyapp.android.ui.main.take2form

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import breon.telematics.loneworkersafetyapp.android.databinding.RowFormActionsBinding
import breon.telematics.loneworkersafetyapp.android.domain.model.request.SWMSFormValues

class Take2FormSwmsOptionsAdapter(private val mList: List<SWMSFormValues>) :
	RecyclerView.Adapter<Take2FormSwmsOptionsAdapter.ViewHolder>() {

	private var selectedPosition: Int = RecyclerView.NO_POSITION
	private val swmsSelection = ArrayList<String>()

	// create new views
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding = RowFormActionsBinding
			.inflate(LayoutInflater.from(parent.context), parent, false)
		return ViewHolder(binding)
	}

	// binds the list items to a view
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		with(holder) {
			with(mList[position]) {
				binding.cbAction.text = action
				binding.cbAction.isChecked = position == selectedPosition
				binding.cbAction.setOnClickListener {
					if (swmsSelection.contains(action)) {
						swmsSelection.remove(action)
					} else {
						swmsSelection.add(action)
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


	fun getSwmsValues(): ArrayList<String> {
		return swmsSelection
	}

	// Holds the views for adding it to image and text
	class ViewHolder(val binding: RowFormActionsBinding) :
		RecyclerView.ViewHolder(binding.root)
}