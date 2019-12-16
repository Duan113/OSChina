package  com.cat.oschina.synthetical.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.cat.oschina.synthetical.adapter.BlogAdapter;
import com.cat.oschina.synthetical.entity.Blog;
import com.example.oschina.synthetical.entity.Question;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BlogFragment extends Fragment {
    private Unbinder binder;
    @BindView(R.id.recyclerBlog)
    RecyclerView recyclerBlog;

    private List<Blog> lists = new ArrayList<>();

    private BlogAdapter mBlogAdapter;


    public  BlogFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog,container,false);
        binder = ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Blog blog = new Blog();
        for (int i = 0;i<30;i++){
            lists.add(blog);
        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerBlog.setLayoutManager(manager);
        mBlogAdapter = new BlogAdapter(R.layout.item_blog,lists);
        recyclerBlog.setAdapter(mBlogAdapter);
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
