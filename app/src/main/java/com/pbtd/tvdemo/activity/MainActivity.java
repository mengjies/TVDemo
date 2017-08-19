/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.pbtd.tvdemo.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.pbtd.tvdemo.R;
import com.pbtd.tvdemo.base.BaseActivity;
import com.pbtd.tvdemo.view.fragment.AnimFragment;
import com.pbtd.tvdemo.view.fragment.ChoiceFragment;
import com.pbtd.tvdemo.view.fragment.DocFragment;
import com.pbtd.tvdemo.view.fragment.MovieFragment;
import com.pbtd.tvdemo.view.fragment.MyFragment;
import com.pbtd.tvdemo.view.fragment.TVFragment;
import com.pbtd.tvdemo.view.fragment.VarietyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;


/*
 * MainActivity class that loads MainFragment
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.rb_choice)
    RadioButton rbChoice;
    @BindView(R.id.rb_tv)
    RadioButton rbTv;
    @BindView(R.id.rb_movie)
    RadioButton rbMovie;
    @BindView(R.id.rb_variety)
    RadioButton rbVariety;
    @BindView(R.id.rb_anim)
    RadioButton rbAnim;
    @BindView(R.id.rb_doc)
    RadioButton rbDoc;
    @BindView(R.id.rb_my)
    RadioButton rbMy;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    private ChoiceFragment choiceFragment;
    private Fragment mContent;
    private TVFragment tvFragment;
    private MovieFragment movieFragment;
    private VarietyFragment varietyFragment;
    private AnimFragment animFragment;
    private DocFragment docFragment;
    private MyFragment myFragment;

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife
        ButterKnife.bind(this);

        initNavigation();

        //density
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float density = metrics.density;
        int densityDpi = metrics.densityDpi;
        Log.e(TAG, "onCreate: density = " + density + "\ndpi = " + densityDpi);

        //initView();

    }

    private void initNavigation() {
        choiceFragment = new ChoiceFragment();
        mContent = choiceFragment;
        switchFragment(choiceFragment);
        // 切换页面
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_choice:
                        if (choiceFragment == null) {
                            choiceFragment = new ChoiceFragment();
                        }
                        switchFragment(choiceFragment);
                        break;
                    case R.id.rb_tv:
                        if (tvFragment == null) {
                            tvFragment = new TVFragment();
                        }
                        switchFragment(tvFragment);
                        break;
                    case R.id.rb_movie:
                        if (movieFragment == null) {
                            movieFragment = new MovieFragment();
                        }
                        switchFragment(movieFragment);
                        break;
                    case R.id.rb_variety:
                        if (varietyFragment == null) {
                            varietyFragment = new VarietyFragment();
                        }
                        switchFragment(varietyFragment);
                        break;
                    case R.id.rb_anim:
                        if (animFragment == null) {
                            animFragment = new AnimFragment();
                        }
                        switchFragment(animFragment);
                        break;
                    case R.id.rb_doc:
                        if (docFragment == null) {
                            docFragment = new DocFragment();
                        }
                        switchFragment(docFragment);
                        break;
                    case R.id.rb_my:
                        if (myFragment == null) {
                            myFragment = new MyFragment();
                        }
                        switchFragment(myFragment);
                        break;
                }
            }
        });
    }

    /**
     * 切换Fragment
     *
     * @param fragment
     */
    private void switchFragment(Fragment fragment) {
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (mContent != fragment) {
            if (fragment.isAdded()) {
                transaction.hide(mContent).show(fragment).commit();
            } else {
                transaction.hide(mContent).add(R.id.frameLayout, fragment).commit();
            }
        } else {
            transaction.add(R.id.frameLayout, fragment).commit();
        }
        mContent = fragment;
    }
}
