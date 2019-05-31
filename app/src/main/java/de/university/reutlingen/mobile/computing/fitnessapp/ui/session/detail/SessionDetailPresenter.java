package de.university.reutlingen.mobile.computing.fitnessapp.ui.session.detail;



import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.TextView;


import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlan;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail.TrainingPlanDetailFragment;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.plan.detail.TrainingPlanDetailPresenter;

public class SessionDetailPresenter {

    private TextView textViewClock;
    private TrainingPlan plan;
    private int selectedExerciseIndex;
    private TrainingPlanDetailPresenter.startSessionListener startSessionListener;
    private SessionDetailView view;
    private FloatingActionButton fabSkipTimer;

    public SessionDetailPresenter(SessionDetailView detailView, TrainingPlan plan, int selectedExerciseIndex){

        this.plan = plan;
        this.view = detailView;
        this.selectedExerciseIndex  = selectedExerciseIndex;

        initializeLayoutComponents();

        //set listner
        if (view.getContext() instanceof TrainingPlanDetailPresenter.startSessionListener){
            this.startSessionListener = ( TrainingPlanDetailPresenter.startSessionListener) view.getContext();
        } else {
            throw new RuntimeException(view.getContext().toString()
                    + " must implement TrainingPlanDetailPresenter.startSessionListener");
        }
    }

    private void initializeLayoutComponents(){
        //timer
        this.textViewClock = view.getView().findViewById(R.id.text_view_session_detail_clock);
        int time = Integer.parseInt( plan.getExerciseList().get(selectedExerciseIndex).getBreakDurationInSeconds());
        displayTimer(time);

        //Floating Action Button to skip timer and return to Exercise overview
        fabSkipTimer = view.getView().findViewById(R.id.fab_session_detail_skip_timer);
        fabSkipTimer.setOnClickListener(v -> {
            startSessionListener.onSessionStart(view.getView(),plan,selectedExerciseIndex);

        });


    }

    private void displayTimer(int time){

        new CountDownTimer(time * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewClock.setText("" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                startSessionListener.onSessionStart(view.getView(),plan,selectedExerciseIndex);

            }

        }.start();
    }

}
