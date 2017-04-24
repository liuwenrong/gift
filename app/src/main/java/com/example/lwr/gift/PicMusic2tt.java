package com.example.lwr.gift;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class PicMusic2tt extends Activity {

	private ImageView imageView;
	int[] images = new int[]{R.drawable.ic_wait, R.drawable.ic_ni, R.drawable.ic_yuwang, R.drawable.ic_biaobai, R.drawable.ic_chengxuyuan, R.drawable.ic_tt_dongman1, R.drawable.ic_tt_dongman2};
	int[] anims = new int[]{R.anim.slide_in_left, R.anim.zoom_in};
	int length = 1;
	int count = 0;
	Context mContext;
	Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what){
				case 0:
					Glide.with(mContext)
							.load(images[count%length])
							.animate(anims[count%2])
							.into(imageView);

//					imageView.setImageResource(images[count%length]);
					count ++;
					Log.e("xx", "count=="+count);
					mHandler.sendEmptyMessageDelayed(0, 3500);
					break;
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mContext = this;
		setContentView(R.layout.pic_music_2_zj);
		imageView = (ImageView) findViewById(R.id.image_view);
		length = images.length;
		mHandler.sendEmptyMessageDelayed(0,1500);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

	void initRecyclerView(){
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        PaintingsRecyclerAdapter paintingAdapter = new PaintingsRecyclerAdapter(this);
//        paintingAdapter.setPaintingClickListener(this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new MarginDecoration(this));
//        recyclerView.setAdapter(paintingAdapter);
//
//        mListTouchInterceptor = findViewById(R.id.touch_interceptor_view);
//        mListTouchInterceptor.setClickable(false);
//
//        mDetailsLayout = findViewById(R.id.details_layout);
//        mDetailsLayout.setVisibility(View.INVISIBLE);
//
//        mUnfoldableView = (UnfoldableView) findViewById(R.id.unfoldable_view);
//
//        mUnfoldableView.setOnFoldingListener(new UnfoldableView.SimpleFoldingListener() {
//            @Override
//            public void onUnfolding(UnfoldableView unfoldableView) {
//                mListTouchInterceptor.setClickable(true);
//                mDetailsLayout.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onUnfolded(UnfoldableView unfoldableView) {
//                mListTouchInterceptor.setClickable(false);
//            }
//
//            @Override
//            public void onFoldingBack(UnfoldableView unfoldableView) {
//                mListTouchInterceptor.setClickable(true);
//            }
//
//            @Override
//            public void onFoldedBack(UnfoldableView unfoldableView) {
//                mListTouchInterceptor.setClickable(false);
//                mDetailsLayout.setVisibility(View.INVISIBLE);
//            }
//        });
//    }
    }


    void initPagedHeadListView(){
        //        mPagedHeadList = (PagedHeadListView) findViewById(R.id.pagedHeadListView);
//
//        mPagedHeadList.addFragmentToHeader(new FirstHeaderFragment());
//        mPagedHeadList.addFragmentToHeader(new SecondHeaderFragment());
//        mPagedHeadList.addFragmentToHeader(new ThirdHeaderFragment());
//        mPagedHeadList.addFragmentToHeader(new FourthHeaderFragment());
//        mPagedHeadList.addFragmentToHeader(new FifthHeaderFragment());
//
//        mPagedHeadList.setHeaderOffScreenPageLimit(4);
//        mPagedHeadList.setHeaderPageTransformer(PageTransformerTypes.FLIP);
//
//        ArrayList<String> mockItemList = new ArrayList<String>();
//
//        for (int i = 0; i < 50; i++)
//            mockItemList.add(getResources().getString(R.string.mock_item) + " " + (i+1));
//
//        MockListAdapter mockListAdapter = new MockListAdapter(getActivity(), R.layout.mock_list_item, mockItemList);
//        mPagedHeadList.setAdapter(mockListAdapter);
    }


}
