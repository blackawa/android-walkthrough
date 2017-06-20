package jp.blackawa.example.autoscrollrecyclerview

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import jp.blackawa.example.autoscrollrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        initRecyclerView()
        initButtons()
    }

    private fun initRecyclerView() {

        binding.recycler.adapter = MyAdapter((0..999).map { it.toString() })
        binding.recycler.layoutManager = LinearLayoutManager(this)
        LinearSnapHelper().attachToRecyclerView(binding.recycler)
    }

    private fun initButtons() {
        binding.buttonNext.setOnClickListener { (binding.recycler.adapter as MyAdapter).incrementSelectedItem() }
        binding.buttonPrevious.setOnClickListener { (binding.recycler.adapter as MyAdapter).decrementSelectedItem() }
    }
}
