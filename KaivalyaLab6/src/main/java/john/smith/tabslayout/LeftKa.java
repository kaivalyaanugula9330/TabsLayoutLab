// Name: Kaivalya Anugula
// Student ID: N01659330
package john.smith.tabslayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LeftKa extends Fragment {

    private RadioGroup kaiRadioGroupColors;

    public LeftKa() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize UI elements
        kaiRadioGroupColors = view.findViewById(R.id.kaiRadioGroupColors);
        Button kaiButtonSubmit = view.findViewById(R.id.kaiButtonSubmit);

        kaiButtonSubmit.setOnClickListener(v -> {
            // Get selected radio button
            int selectedId = kaiRadioGroupColors.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(getActivity(), R.string.please_select_a_color, Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedRadioButton = view.findViewById(selectedId);
            String selectedColor = selectedRadioButton.getText().toString().trim();

            // Show Toast message
            Toast.makeText(getActivity(), getString(R.string.selected_color1) + selectedColor, Toast.LENGTH_LONG).show();

            // Send selected color to RightSi using Fragment Result API
            Bundle bundle = new Bundle();
            bundle.putString(getString(R.string.selectedcolor), selectedColor);
            getParentFragmentManager().setFragmentResult(getString(R.string.colorkey), bundle);

            // Switch to Tab 2
            ViewPager2 viewPager = requireActivity().findViewById(R.id.kaiViewPager);
            viewPager.setCurrentItem(1, true); // Move to RightSi (Tab 2) smoothly
        });
    }
}
