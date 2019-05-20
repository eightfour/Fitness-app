package de.university.reutlingen.mobile.computing.fitnessapp.ui.plan;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import de.university.reutlingen.mobile.computing.fitnessapp.R;
import de.university.reutlingen.mobile.computing.fitnessapp.rest.client.v1.TrainingPlansRequest;
import de.university.reutlingen.mobile.computing.fitnessapp.ui.model.TrainingPlanReference;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link TrainingPlanSelectionListener}
 * interface.
 */
public class TrainingPlansFragment extends Fragment {

    private TrainingPlanSelectionListener selectionListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TrainingPlansFragment() {
        // nothing to do
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trainingplans_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set the listener
        if (getContext() instanceof TrainingPlanSelectionListener){
            this.selectionListener = (TrainingPlanSelectionListener) getContext();
        } else {
            throw new RuntimeException(getContext().toString()
                    + " must implement TrainingPlanSelectionListener");
        }

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            final TrainingPlansRecyclerViewAdapter adapter = new TrainingPlansRecyclerViewAdapter(new ArrayList<>(), selectionListener);
            recyclerView.setAdapter(adapter);

            final RequestQueue queue = Volley.newRequestQueue(view.getContext());
            final TrainingPlansRequest trainingPlansRequest = new TrainingPlansRequest(response -> {
                adapter.updateItems(response);
                adapter.notifyDataSetChanged();
            }, error -> {
                System.out.println("ERROR Loading Training Plans");
            });
            queue.add(trainingPlansRequest);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface TrainingPlanSelectionListener {
        void onListFragmentInteraction(TrainingPlanReference item);
    }

}
