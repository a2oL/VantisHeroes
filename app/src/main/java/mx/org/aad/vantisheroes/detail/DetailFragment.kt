package mx.org.aad.vantisheroes.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.org.aad.vantisheroes.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val rickProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailViewModelFactory(rickProperty, application)
        binding.viewModel = ViewModelProvider(
                this, viewModelFactory).get(DetailViewModel::class.java)

        return binding.root
    }
}