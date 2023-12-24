package com.ozanyazici.artbookfragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Database
import androidx.room.Room
import com.ozanyazici.artbookfragment.adapter.ArtAdapter
import com.ozanyazici.artbookfragment.databinding.FragmentArtListBinding
import com.ozanyazici.artbookfragment.databinding.FragmentDetailsBinding
import com.ozanyazici.artbookfragment.model.Art
import com.ozanyazici.artbookfragment.roomdb.ArtDao
import com.ozanyazici.artbookfragment.roomdb.ArtDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class ArtListFragment : Fragment() {

    private var _binding: FragmentArtListBinding? = null
    private val binding get() = _binding ?: throw IllegalStateException("Attempt to access binding when it is null.")
    private lateinit var db: ArtDatabase
    private lateinit var artDao: ArtDao
    private var myDisposable =  CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(requireContext(),ArtDatabase::class.java,"Arts").build()
        artDao = db.artDao()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentArtListBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myDisposable.add(artDao.getArtWithNameAndId()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }

    fun handleResponse(artList: List<Art>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = ArtAdapter(artList)
        binding.recyclerView.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}