package john.smith.tabslayout;
/*
 * Name: Kaivalya Anugula
 * Student ID: N01659330
 */

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class KaivalyaActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a list of fragments to be displayed in ViewPager
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new LeftKa()); // First tab fragment
        fragmentList.add(new RightAn()); // Second tab fragment

        // Initialize ViewPager2 and set its adapter
        ViewPager2 viewPager = findViewById(R.id.kaiViewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this, fragmentList));

        // Initialize TabLayout
        TabLayout tabLayout = findViewById(R.id.kaiTabLayout);

        // Attach TabLayout with ViewPager2 and set tab titles dynamically
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText(getString(R.string.tab_1)); // Using strings.xml
                    } else {
                        tab.setText(getString(R.string.tab_2)); // Using strings.xml
                    }
                }
        ).attach();
    }
}
