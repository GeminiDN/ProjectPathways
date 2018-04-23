package com.dn.gemini.projectpathways;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

/**
 * Created by danielphillips on 4/19/18.
 */

public class maps_activity extends AppCompatActivity implements OnMapReadyCallback {
    MaterialSearchView searchView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.maps_activity);
            setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        /**
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we
         * just add a marker near Africa.
         */
        @Override
        public void onMapReady(GoogleMap map) {
            map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, true);

                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_action_search:

                finish();
                break;
            case R.id.map_action_mylocation:

                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_menu, menu);
        //MenuItem searchItem = menu.findItem(R.id.map_action_search);
        MenuItem item = menu.findItem(R.id.map_action_search);


        //searchView.setQueryHint("Search...");
//        searchView.setOnSearchClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

        MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setSubmitOnClick(true);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(maps_activity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });


        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

        searchView.setMenuItem(item);
        String[] matches = {"Bursary / Campus Registrar's Ousce / HR Appointments","Administration – Student Administration Building","(Lloyd Braithwaite Building) / Admissions (UG) / Alumni Association / ","Examinations / School of Graduate Studies and Research / Student ","Advisory Services / UWI Endowment Fund","ASDLU – Academic Support & Disabilities Liaison Unit","Research Development and Knowledge Transfer Ousce ","Campus IT Services (CITS)","Campus Principal’s Ousce","Campus Projects Ousce","Campus Security","Campus Security – UWI Estate Police","Deputy Principal’s Ousce","Facilities Management Buildings ","Guild Ousce / SAC Manager's Ousce","Health Services Unit & Pharmacy","Human Resources","IDU - Instructional Development Unit ","(Sir Frank Stockdale Building)","Marketing and Communications Ousce","Planning and Development Ousce ","Quality Assurance Unit (Dudley Huggins Building) ","FACULTY OF ENGINEERING ","Engineering Block 1 - Dean's Ousce (Engineering) / Electrical Engineering /","Mechanical Engineering (Kenneth S. Julien Building)","Engineering Block 2 – Civil Engineering","Engineering Block 3 – Mechanical Engineering","Engineering Block 4 – Mechanical Engineering Lab ","Engineering Block 5 – Engineering Stores and Workshop","Engineering Block 6 – Lecture Rooms (5, 5.1,6,7, 8)","Engineering Block 7 – Environmental & Fluids Lab ","Engineering Block 8 – Chemical Engineering","Engineering Block 9 – Food Sciences & Technology and Biotechnology ","(George Moon Sammy Building)","Engineering Block 10 – Surveying & Land Information","Engineering Block 11 – Systems Lab ","Engineering Block 13 - Mechanical Engineering  (Max Richards Building)","FACULTY OF HUMANITIES & EDUCATION ","Arcon 1","Arcon 2","Campus House","Dean's Ousce (Humanities & Education)/ Archaeology Workshop","Department for Creative and Festival Arts (DCFA) – Gordon Street","Department for Creative and Festival Arts (DCFA) – Agostini Street","Education Library","School of  Education","School of  Education","Film Programme Building ","Humanities (FL3) – SB 1, 2, 3","Humanities Lecture Rooms (FL3) 307, 308, 314, 330 ","Multimedia Production Center (MPC)","UWI Family Development and Children’s Research Centre (FDCRC)","FACULTY OF LAW ","Faculty of Law/ SALISES","FACULTY OF FOOD & AGRICULTURE ","Dean's Ousce (Science and Agriculture) - Sir Frank Stockdale Building/ ","Department of Food Production ","Biotechnology Unit/ Tissue Culture Unit/ Cocoa Research Greenhouses ","Department of Soil Science/ Agriculture Labs","Department of Agricultural Economics & Extension / CARDI/ ","Frederick Hardy Building ","Dudley Huggins Building - Department of Agricultural Economics and ","Extension/ Agricultural Economics Unit/ Human Ecology Programme","Food Production - Food Biology Lab","Greenhouses","Sir Frank Stockdale Building","Soil Science Lab - Department of Food Production","28","24","FACULTY OF SCIENCE & TECHNOLOGY","Chemistry – C1, Lab B","Chemistry – C2","Chemistry – C3","Chemistry – C4","Natural Sciences (Life Sciences, Mathematics and Computer Science, Physics)","Department of Life Sciences / Zoology Museum","FACULTY OF SOCIAL SCIENCES ","Computer Lab: Social Sciences Computer Lab","Deane House / Mediation Studies & Resource Studies","Dean's Ousce (Social Sciences) / Dean's Meeting Room","Department of Management","Department of Economics / Department of Behavioural Sciences","Evening University Ousce","FSS Criminology Lecture Room A & B","Management Lecture Theatre","INSTITUTES, CENTRES, UNITS & LIBRARIES","Alma Jordan Library","ANSA McAl Psychological Research Unit (PRU)","CARDI – Caribbean Agricultural Research and Development Institute ","/ Frederick Hardy Building","CARIRI – Caribbean Industrial Research Institute ","CCMF – Caribbean Centre for Money and Finance / Bookshop / Open Campus","CFNI – Caribbean Food and Nutrition Institute / Journal of Tropical Agriculture","CHRC – Caribbean Health and Research Council / Campus Projects Ousce","CLL – Centre for Language Learning / Institute of Critical Thinking","CRU – Cocoa Research Unit (Sir Frank Stockdale Building)","Herbarium, The National (Sir Frank Stockdale Building )","HEU, Health Economics Centre (Sir George Alleyne Building)","IGDS – Institute of Gender and Development Studies / Social Work/ Records Centre / C2","IIR – Institute of International Relations / Centre for Latin America and the Caribbean","SALISES – Sir Arthur Lewis Institute of Social and Economic Studies / Faculty of Law","Seismic Research Centre","Teaching and Learning Complex ","UWI Family Development and Children’s Research Centre (FDCRC)","STUDENT HALLS OF RESIDENCE","Canada Hall","Milner Hall","Sir Arthur Lewis Hall of Residence","Trinity Hall","OTHER","Cemetery","Sixth Form School","The University School (for Children – UWI Ausliated)","Parking","Gate","Emergency Telephone","TEMPORARY CLASSROOMS,","GENERAL LECTURE  THEATRES, AUDITORIUMS","Daaga Auditorium ","JFK Auditorium & Lecture Theatre","Learning Resource Centre (LRC)","Management Lecture Theatre (MLT)","Temporary Classroom Building (TCB# 1)/ Heartease Facility","Temporary Classroom Building (TCB# 3)/ Chemistry","Temporary Classroom Building (TCB# 2)/ Natural Sciences","FOOD, SERVICES, SPORTS, RECREATION","ATSS Stars Social Club","Bookshop / CCMF/ Open Campus","Cafeteria (JFK Food Court) KFC / Subway / Mario's Pizza / Boomers/ ","Fruit Stall / Digicel / Veg Out / Sava d Flava","Catholic Chaplaincy","Guild Cafeteria, Pub (Club Equinox), Ritual's / bmobile / ASDLU","Post Office / Open Campus","Republic Bank / Open Campus","Senior Common Room (SCR)","Sport and Physical Education Centre – SPEC","Sports: Lawn Tennis Complex","Sports: Player’s Pavilion","Sports: Swimming Pool","Student Activity Centre (SAC) – DocuCentre, Cafeteria"};
        searchView.setSuggestions(matches);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
