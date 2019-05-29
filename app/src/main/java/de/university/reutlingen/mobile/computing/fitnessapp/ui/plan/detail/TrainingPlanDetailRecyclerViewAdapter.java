package de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.Exercise;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlanReference;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.TrainingPlansFragment.TrainingPlanSelectionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link TrainingPlanReference} and makes a call to the
 * specified {@link TrainingPlanSelectionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TrainingPlanDetailRecyclerViewAdapter extends RecyclerView.Adapter<TrainingPlanDetailRecyclerViewAdapter.MyViewHolder> {

    private List<Exercise> mValues;
    private final TrainingPlanDetailFragment.TrainingPlanDetailSelectionListener selectionListener;


    public TrainingPlanDetailRecyclerViewAdapter(List<Exercise> items, TrainingPlanDetailFragment.TrainingPlanDetailSelectionListener listener) {
        mValues = items;
        selectionListener = listener;
    }

    public void updateItems(List<Exercise> items) {
        this.mValues = items;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //set values to text views
        System.out.println("bind ViewHolder");
        holder.mItem = mValues.get(position);
        holder.mWeight.setText(mValues.get(position).getIntensityLevel()+ " kg");
        holder.mRepetitions.setText(mValues.get(position).getNumOfRepetitions());
        holder.mBreakTime.setText(mValues.get(position).getBreakDurationInSeconds());
        holder.mNumOfSets.setText(mValues.get(position).getNumOfSets());
        holder.mExerciseName.setText(mValues.get(position).getExerciseDetail().getName());

        //set button functionality to show exercise decription
        holder.btnShowExerciseDescription.setOnClickListener(view ->{
                if(!holder.actionBtnShowExerciseDescriptionIsClicked) {
                    holder.mDescription.setText(mValues.get(position).getExerciseDetail().getDescription());
                }else{
                    holder.mDescription.setText("");
                }

                holder.actionBtnShowExerciseDescriptionIsClicked = !holder.actionBtnShowExerciseDescriptionIsClicked;
        });

        //set listener when an exercise is clicked
        holder.mView.setOnClickListener(v -> {
            if (null != selectionListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                selectionListener.onListFragmentInteraction(holder.mItem,holder.mExerciseName);
            }
        });
    }




    @Override
    public TrainingPlanDetailRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_training_plan_detail, viewGroup, false);
        return new MyViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView mWeight;
        public final TextView mRepetitions;
        public final TextView mDescription;
        public final TextView mNumOfSets;
        public final TextView mBreakTime;
        public final TextView mExerciseName;
        public final FloatingActionButton btnShowExerciseDescription;
        public boolean actionBtnShowExerciseDescriptionIsClicked = false;

        public Exercise mItem;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mExerciseName = (TextView) view.findViewById(R.id.textView_Exercise_Name);
            mWeight = (TextView) view.findViewById(R.id.textView_Exercise_Weight);
            mRepetitions = (TextView) view.findViewById(R.id.textView_Exercise_Repetitions);
            mNumOfSets = (TextView) view.findViewById(R.id.textView_Exercise_NumOfSets);
            mDescription = (TextView) view.findViewById(R.id.textView_Exercise_Description);
            mBreakTime = (TextView) view.findViewById(R.id.textView_Exercise_BreakTime);
            btnShowExerciseDescription = (FloatingActionButton) view.findViewById(R.id.btn_show_Exercise_Description);
        }


    }
}
