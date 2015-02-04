// Generated code from Butter Knife. Do not modify!
package com.r0adkll.slidr.example;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.r0adkll.slidr.example.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361856, "field 'mRecycler'");
    target.mRecycler = (android.widget.Button) view;
  }

  public static void reset(com.r0adkll.slidr.example.MainActivity target) {
    target.mRecycler = null;
  }
}
