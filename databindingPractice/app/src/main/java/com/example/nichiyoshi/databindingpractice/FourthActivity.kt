package com.example.nichiyoshi.databindingpractice

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class FourthActivity: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val myDataset = arrayListOf(1,2,3,4,5,6,7,8,9,10).map { value -> User(value.toString(), "dayo") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forth)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(myDataset)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

    class MyAdapter(private val myDataset: List<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        class MyViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): MyAdapter.MyViewHolder {

            val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)

            val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.recyclerview_item, parent, false )
            return MyViewHolder(binding)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val user = myDataset[position]
            holder.binding.setVariable(BR.user, user)
        }

        override fun getItemCount() = myDataset.size
    }
}