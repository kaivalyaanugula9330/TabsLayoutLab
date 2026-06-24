package john.smith.tabslayout;
/*
 * Name: Kaivalya Anugula
 * Student ID: N01659330
 */

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RightAn extends Fragment {

    private TextView kaiSelectedColorTextView;
    private CheckBox kaiCheckHockey, kaiCheckBasketball, kaiCheckBaseball;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right_an, container, false);

        // Initialize Views
        kaiSelectedColorTextView = view.findViewById(R.id.kaiSelectedColorText);
        kaiCheckHockey = view.findViewById(R.id.kaiCheckHockey);
        kaiCheckBasketball = view.findViewById(R.id.kaiCheckBasketball);
        kaiCheckBaseball = view.findViewById(R.id.kaiCheckBaseball);
        Button kaiSportBtn = view.findViewById(R.id.kaiButtonSport);

        // Listen for color result from LeftSo fragment
        getParentFragmentManager().setFragmentResultListener(getString(R.string.colorkey1), this, (requestKey, result) -> {
            String selectedColor = result.getString(getString(R.string.selectedcolor1), getString(R.string.no_data));

            // Display with "Selected Color:" prefix
            String displayText = getString(R.string.selected_color) + " " + selectedColor;
            kaiSelectedColorTextView.setText(displayText);

            // Set the color based on the selected color
            switch (selectedColor) {
                case "Green":
                case "Vert": // French translation
                    kaiSelectedColorTextView.setTextColor(Color.GREEN);
                    break;
                case "Yellow":
                case "Jaune": // French translation
                    kaiSelectedColorTextView.setTextColor(Color.YELLOW);
                    break;
                case "Red":
                case "Rouge": // French translation
                    kaiSelectedColorTextView.setTextColor(Color.RED);
                    break;
                case "Other":
                    kaiSelectedColorTextView.setTextColor(Color.DKGRAY);
                    break;
                default:
                    kaiSelectedColorTextView.setTextColor(Color.GRAY);
                    break;
            }
        });

        //  Handle SPORT button click
        kaiSportBtn.setOnClickListener(v -> {
            StringBuilder selectedSports = new StringBuilder();

            if (kaiCheckHockey.isChecked()) {
                selectedSports.append(getString(R.string.sport_hockey)).append("\n");
            }
            if (kaiCheckBasketball.isChecked()) {
                selectedSports.append(getString(R.string.sport_basketball)).append("\n");
            }
            if (kaiCheckBaseball.isChecked()) {
                selectedSports.append(getString(R.string.sport_baseball)).append("\n");
            }

            //  Show selected sports in AlertDialog with sport.png image
            String displayMessage = selectedSports.length() == 0
                    ? getString(R.string.no_sports_selected)
                    : selectedSports.toString();

            new AlertDialog.Builder(getActivity())
                    .setTitle(getString(R.string.sports_selection))
                    .setMessage(displayMessage)
                    .setIcon(R.drawable.sports)
                    .setPositiveButton(getString(R.string.ok_button), null)
                    .show();
        });

        return view;
    }
}
