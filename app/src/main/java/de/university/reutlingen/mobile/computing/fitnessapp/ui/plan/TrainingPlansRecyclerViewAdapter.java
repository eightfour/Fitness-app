package de.university.reutlingen.mobile.computing.fitnessapp.ui.plan;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlanReference;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.TrainingPlansFragment.TrainingPlanSelectionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link TrainingPlanReference} and makes a call to the
 * specified {@link TrainingPlanSelectionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TrainingPlansRecyclerViewAdapter extends RecyclerView.Adapter<TrainingPlansRecyclerViewAdapter.ViewHolder> {

    private List<TrainingPlanReference> mValues;
    private final TrainingPlanSelectionListener selectionListener;

    public TrainingPlansRecyclerViewAdapter(List<TrainingPlanReference> items, TrainingPlanSelectionListener listener) {
        mValues = items;
        selectionListener = listener;
    }

    public void updateItems(List<TrainingPlanReference> items){
        this.mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_trainingplans, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getName());
        holder.mContentView.setText(mValues.get(position).getIdentifier());

        holder.mView.setOnClickListener(v -> {
            if (null != selectionListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                selectionListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public TrainingPlanReference mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
