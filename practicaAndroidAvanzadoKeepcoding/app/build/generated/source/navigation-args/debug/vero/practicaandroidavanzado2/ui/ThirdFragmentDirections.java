package vero.practicaandroidavanzado2.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import vero.practicaandroidavanzado2.R;

public class ThirdFragmentDirections {
  private ThirdFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionThirdToFirstFragment() {
    return new ActionOnlyNavDirections(R.id.action_Third_to_FirstFragment);
  }

  @NonNull
  public static NavDirections actionThirdToSecondFragment() {
    return new ActionOnlyNavDirections(R.id.action_Third_to_SecondFragment);
  }
}
