package vero.practicaandroidavanzado2.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import vero.practicaandroidavanzado2.R;

public class SecondFragmentDirections {
  private SecondFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSecondFragmentToFirstFragment() {
    return new ActionOnlyNavDirections(R.id.action_SecondFragment_to_FirstFragment);
  }

  @NonNull
  public static NavDirections actionSecondFragmentToThirdFragment() {
    return new ActionOnlyNavDirections(R.id.action_SecondFragment_to_ThirdFragment);
  }
}
