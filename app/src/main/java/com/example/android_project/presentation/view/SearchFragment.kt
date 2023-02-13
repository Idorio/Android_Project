package com.example.android_project.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android_project.databinding.FragmentSearchBinding
import com.example.android_project.utils.rx.RxJavaExample
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.ReplaySubject

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        RxJavaExample().observableJustOne()

        RxJavaExample().observableJustTwo()

        RxJavaExample().observableJustThree()

        RxJavaExample().observableJustFor()

        RxJavaExample().observableJustFive()

        RxJavaExample().observableJustSixe()

        RxJavaExample().publishSubject()

        RxJavaExample().replaySubject()

        RxJavaExample().behaviorSubject()

        RxJavaExample().asyncSubject()

    }

}