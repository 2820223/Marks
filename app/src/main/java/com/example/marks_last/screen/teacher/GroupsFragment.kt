package com.example.marks_last.screen.teacher

import com.example.marks_last.adapter.GroupsAdapter
import com.example.marks_last.database.AppDataBase


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marks_last.util.ShPHelper
import uz.itschool.marks.R
import uz.itschool.marks.databinding.FragmentGroupsBinding

class GroupsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val shPHelper = ShPHelper.getInstance(requireContext())
        val binding = FragmentGroupsBinding.inflate(inflater, container, false)
        val appDataBase = AppDataBase.getInstance(requireContext())
        val teacherId = shPHelper.getUser()!![0].toInt()

        binding.groupsRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.groupsRecycler.adapter = GroupsAdapter(requireContext(), appDataBase, teacherId, object : GroupsAdapter.GoMArks{
            override fun pressed(group: com.example.marks_last.database.entity.Group) {
                parentFragmentManager.beginTransaction().replace(R.id.teacherr_frag_container, MarksFragment.newInstance(teacherId, group.id), "1").addToBackStack("").commit()
            }
        })

        return binding.root
    }

}