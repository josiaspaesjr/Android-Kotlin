package com.paes.josias.android_kotlin_googlemaps

import android.app.ProgressDialog
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var latlng: LatLng

    lateinit var progress: ProgressDialog

    private var strEnd = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapClickListener(this@MapsActivity)

        val jampa = LatLng(-7.1588384,-34.8576049)

        mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE

        mMap.addMarker(createMarkers(jampa, "My Jampa", "A wonderfull city"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jampa, 18.5f))
    }

    fun createMarkers(latLng: LatLng, title:String, snippet:String): MarkerOptions{
        return MarkerOptions()
                .position(latLng)
                .title(title)
                .snippet(snippet)
                //.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
    }

    override fun onMapClick(latlng:LatLng) {
        this.latlng = latlng

        progress = ProgressDialog(this)
        progress.setTitle("Carregando endereço ...")
        progress.show();

        ReserveLatLngToAddress().execute()
    }

    fun goToAddress(v:View){

        progress = ProgressDialog(this)
        progress.setTitle("Carregando endereço ...")
        progress.show();

        strEnd = etEnd.text.toString()

        ReserveAddressToLatLng().execute()
    }


    inner class ReserveLatLngToAddress : AsyncTask<Void, Void, Address>(){

        override fun doInBackground(vararg p0: Void?): Address? {
            try {

                var geo = Geocoder(this@MapsActivity)
                var addresses = geo.getFromLocation(this@MapsActivity.latlng.latitude
                        ,this@MapsActivity.latlng.longitude
                        , 1)

                return addresses.get(0)

            }catch (e:Exception){
                return null
            }
        }

        override fun onPostExecute(result: Address?) {

            this@MapsActivity.progress.dismiss()

            if(result != null){
                this@MapsActivity.mMap.addMarker(
                        this@MapsActivity.createMarkers(
                                this@MapsActivity.latlng,
                                result.thoroughfare,
                                result.locality + " - " + result.postalCode
                        )
                )
            }
        }
    }

    inner class ReserveAddressToLatLng : AsyncTask<Void, Void, Address>(){

        override fun doInBackground(vararg p0: Void?): Address? {
            try {

                var geo = Geocoder(this@MapsActivity)
                val addresses = geo.getFromLocationName(this@MapsActivity.strEnd, 1)
                return addresses.get(0)

            }catch (e:Exception){
                return null
            }
        }

        override fun onPostExecute(result: Address?) {

            this@MapsActivity.progress.dismiss()

            if(result != null){
                var latlng = LatLng(result.latitude, result.longitude)
                this@MapsActivity.mMap.addMarker(
                        this@MapsActivity.createMarkers(
                                latlng,
                                result.thoroughfare,
                                result.locality + " - " + result.postalCode
                        )
                )
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 18.5f))
            }
        }
    }
}
