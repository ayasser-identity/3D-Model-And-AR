package com.example.modelviewer.ui.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.modelviewer.R
import com.example.modelviewer.databinding.FragmentHomeBinding
import com.example.modelviewer.utils.viewbinding.viewBinding


class HomeFragment : androidx.fragment.app.Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            modelViewerButton.setOnClickListener { modelViewerButtonClicked() }
            arCoreButton.setOnClickListener { arCoreButtonClicked() }
        }
    }

    private fun modelViewerButtonClicked() {
        findNavController().navigate(HomeFragmentDirections.actionModelViewerFragmentToModelViewerFragment())
//        val assetsDirectory = File(requireContext().filesDir, "assets")
//        val url = "https://ayasser-identity.github.io/githubpagestrial/"
//        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        i.setPackage("com.android.chrome")
//        try {
//            startActivity(i)
//        } catch (e: ActivityNotFoundException) {
//            // Chrome is probably not installed
//            // Try with the default browser
//            i.setPackage(null)
//            startActivity(i)
//        }
    }

    private fun arCoreButtonClicked() {
//        val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
//        sceneViewerIntent.data =
//            Uri.parse(getString(R.string.model_url))
//        sceneViewerIntent.setPackage(getString(R.string.scene_viewer_package))
//        startActivity(sceneViewerIntent)
        val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
        val intentUri = Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
            .appendQueryParameter(
                "file",
                "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Duck/glTF/Duck.gltf"
            )
            .appendQueryParameter("mode", "3d_preferred")
            .appendQueryParameter("title", "ahmedh")
            .build()
        sceneViewerIntent.data = intentUri
        sceneViewerIntent.setPackage("com.google.ar.core")
        startActivity(sceneViewerIntent)
    }
}
