package fr.istic.mmm.scinov.activities.Event.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

import fr.istic.mmm.scinov.R;
import fr.istic.mmm.scinov.activities.Event.model.Event;
import fr.istic.mmm.scinov.helpers.Filter;
import fr.istic.mmm.scinov.helpers.MyUtil;

public class EventsListAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<Event> list;
    private List<Event> listCopy;
    private MenuItem menuSearchItem;
    private Filter filter;

    public EventsListAdapter(MenuItem menuSearchItem) {
        this.list = new LinkedList<>();
        Log.i("SEARCHING", "adapter created");
        this.menuSearchItem = menuSearchItem;
        filter = new Filter();
    }

    public Filter getFilter(){
        return filter;
    }

    public void setMenuSearchItem(MenuItem menuSearchItem){
        this.menuSearchItem = menuSearchItem;
    }

    public void setList(List<Event> list) {
        this.list = new LinkedList<>(list);
        this.listCopy = new LinkedList<>(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_card,viewGroup,false);
        if(menuSearchItem != null){
            MyUtil.clickOutsideToUnfocusSearch(view, menuSearchItem);
        }
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int position) {
        Event event = list.get(position);
        eventViewHolder.bind(event);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filter(String query) {

        Log.i("FILTER_DATE", "Filtering");
        list.clear();
        if(query.isEmpty() && filter.getDate() == null){
            Log.i("FILTER_DATE", "no filter");
            list.addAll(listCopy);
        }else{
            for(Event event: listCopy){
//                Log.i("FILTER_DATE", event.getFormattedDates().toString());
//                Log.i("FILTER_DATE", filter.getDate().toString());
                if((filter.getDate() == null || (event.getFormattedDates().size() != 0 && event.getFormattedDates().contains(filter.getDate())))){
                    if(query.isEmpty()){
                        Log.i("FILTER_DATE", "no query");
                        list.add(event);
                    }else{
                        Log.i("FILTER_DATE", "with query");
                        query = query.toLowerCase();
                        if((event.getName() != null && filter.isFilterByName() && event.getName().toLowerCase().contains(query))
                                || (event.getCity() != null && filter.isFilterByPlace() && event.getCity().toLowerCase().contains(query))
                                || (event.getDescription() != null && filter.isFilterByDescription() && event.getDescription().toLowerCase().contains(query))
                                || (event.getKeywords() != null && filter.isFilterByKeyword() && event.getKeywords().toLowerCase().contains(query))
                                || (event.getTheme() != null && filter.isFilterByTheme() && event.getTheme().toLowerCase().contains(query))){
                            list.add(event);
                        }
                    }
                }

            }
        }
        notifyDataSetChanged();
    }
}