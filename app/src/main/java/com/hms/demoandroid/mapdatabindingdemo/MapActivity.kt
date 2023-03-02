package com.hms.demoandroid.mapdatabindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hms.demoandroid.mapdatabindingdemo.databinding.ActivityMapBinding
import com.huawei.hms.maps.CameraUpdateFactory
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.MapView
import com.huawei.hms.maps.model.LatLng

class MapActivity : AppCompatActivity() {
    lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMapBinding.inflate(layoutInflater)

        setContentView(binding.root)
        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY_2)
        }
        mapView=binding.fullMapView.apply {
            onCreate(mapViewBundle)
            getMapAsync{huaweiMap->onMapReady(huaweiMap)}
        }
    }

    private fun onMapReady(huaweiMap: HuaweiMap?) {
        //doSomething with the map
        val latLon= LatLng(-12.04318, -77.02824)
        val cameraUpdate= CameraUpdateFactory.newLatLngZoom(latLon,15.0f)
        huaweiMap?.animateCamera(cameraUpdate)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var mapViewBundle: Bundle? = outState.getBundle(MAPVIEW_BUNDLE_KEY_2)
        if (mapViewBundle == null) {
            mapViewBundle = Bundle()
            outState.putBundle(MAPVIEW_BUNDLE_KEY_2, mapViewBundle)
        }
        mapView.onSaveInstanceState(mapViewBundle)
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    companion object {
        private const val MAPVIEW_BUNDLE_KEY_2 = "MapViewBundleKey2"
    }
}