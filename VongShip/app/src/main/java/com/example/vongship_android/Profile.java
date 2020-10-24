package com.example.vongship_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends Fragment {
    private ListView listView;
    int imgIcon[] = {R.drawable.ic_emotion, R.drawable.ic_favorite, R.drawable.ic_edit, R.drawable.ic_card, R.drawable.ic_help, R.drawable.ic_textsms, R.drawable.ic_textsms, R.drawable.ic_phone, R.drawable.ic_logout};
    String mTitle[] = {"Cộng đồng Loship", "Cửa hàng yêu thích", "Quản lý hồ sơ", "Quản lý thẻ", "Câu hỏi thường gặp", "Đề xuất cửa hàng mong muốn", "Đóng góp tính năng Loship", "Liên hệ với Loship", "Đăng xuất"};
    int imgForward[] = {R.drawable.ic_forward, R.drawable.ic_forward, R.drawable.ic_forward, R.drawable.ic_forward, R.drawable.ic_forward, R.drawable.ic_forward, R.drawable.ic_forward, R.drawable.ic_forward, R.drawable.ic_null};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_profile,container,false);listView = root.findViewById(R.id.listView);
        Profile.Adapter adapter = new Profile.Adapter(getActivity(), imgIcon, mTitle, imgForward);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(getActivity(), "Community", Toast.LENGTH_SHORT).show();
                }
                if(position == 1){
                    Toast.makeText(getActivity(), "Favorite Shop", Toast.LENGTH_SHORT).show();
                }
                if(position == 2){
                    Toast.makeText(getActivity(), "Profile Manage", Toast.LENGTH_SHORT).show();
                }
                if(position == 3){
                    Toast.makeText(getActivity(), "Card Manage", Toast.LENGTH_SHORT).show();
                }
                if(position == 4){
                    Toast.makeText(getActivity(), "Question", Toast.LENGTH_SHORT).show();
                }
                if(position == 5){
                    Toast.makeText(getActivity(), "Offer", Toast.LENGTH_SHORT).show();
                }
                if(position == 6){
                    Toast.makeText(getActivity(), "Feature", Toast.LENGTH_SHORT).show();
                }
                if(position == 7){
                    Toast.makeText(getActivity(), "Contact", Toast.LENGTH_SHORT).show();
                }
            }
        });




        return root;
    }
    class Adapter extends ArrayAdapter<String> {
        Context context;
        int rIcon[];
        String rTitle[];
        int rForward[];
        Adapter (Context c, int icon[], String title[], int forward[]){
            super(c, R.layout.rows, R.id.titleTv, title);
            this.context = c;
            this.rIcon = icon;
            this.rTitle = title;
            this.rForward = forward;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rows = layoutInflater.inflate(R.layout.rows, parent, false);
            ImageView imgIcon = rows.findViewById(R.id.imgIcon);
            TextView mTitle = rows.findViewById(R.id.titleTv);
            ImageView imgForward = rows.findViewById(R.id.imgForward);

            imgIcon.setImageResource(rIcon[position]);
            mTitle.setText(rTitle[position]);
            imgForward.setImageResource(rForward[position]);
            return rows;
        }
    }
}