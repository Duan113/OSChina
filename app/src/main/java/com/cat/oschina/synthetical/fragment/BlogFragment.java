package  com.cat.oschina.synthetical.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cat.oschina.R;
import com.cat.oschina.net.URLList;
import com.cat.oschina.synthetical.adapter.BlogAdapter;
import com.cat.oschina.synthetical.entity.Blog;
import com.cat.oschina.synthetical.net.BlogResult;
import com.cat.oschina.util.ACache;
import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.callback.Callback;


import java.io.IOException;
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
        Log.d("url", "Blog onViewCreated: url:"+ URLList.GET_BLOG + ACache.get(getActivity()).getAsString("token"));
        OkHttpUtil.getDefault(this)
                .doGetAsync(HttpInfo.Builder().setUrl(URLList.GET_BLOG + ACache.get(getActivity()).getAsString("token")).build(), new Callback() {
                    @Override
                    public void onSuccess(HttpInfo info) throws IOException {
                        BlogResult result = info.getRetDetail(BlogResult.class);
                        mBlogAdapter.replaceData(result.getBloglist());
                    }

                    @Override
                    public void onFailure(HttpInfo info) throws IOException {
                        System.out.println(info);

                    }
                });
//        Blog blog = new Blog();
//        for (int i = 0;i<30;i++){
//            lists.add(blog);
//        }
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerBlog.setLayoutManager(manager);
        mBlogAdapter = new BlogAdapter(R.layout.item_blog,lists);
        recyclerBlog.setAdapter(mBlogAdapter);

        View view1 = View.inflate(getActivity(),R.layout.blog_picture,null);
        mBlogAdapter.addHeaderView(view1);
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
}
