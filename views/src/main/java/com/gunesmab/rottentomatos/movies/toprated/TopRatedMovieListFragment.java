package com.gunesmab.rottentomatos.movies.toprated;

import com.gunesmab.rottentomatos.R;
import com.gunesmab.rottentomatos.adapter.BasicAdapter;
import com.gunesmab.rottentomatos.databinding.FragmentTopRatedMovieListBinding;
import com.gunesmab.rottentomatos.fragment.BaseFragment;
import com.gunesmab.viewmodels.ListItemMovieViewModel;


public class TopRatedMovieListFragment extends BaseFragment<FragmentTopRatedMovieListBinding> {



    @Override
    protected void bindData(FragmentTopRatedMovieListBinding dataBinding) {
        final BasicAdapter<ListItemMovieViewModel> adapter = new BasicAdapter<>();
        dataBinding.topRatedMovieList.setAdapter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top_rated_movie_list;
    }
}
