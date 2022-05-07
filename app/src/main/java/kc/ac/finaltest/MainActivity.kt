package kc.ac.finaltest

import android.content.AbstractThreadedSyncAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kc.ac.finaltest.Adapter.SafeAdapter
import kc.ac.finaltest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SafeAdapter

    companion object{
        const val API_KEY = "76764650446a697736337474474176"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelFactory = MainViewModel.MainViewModelFactory()

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        adapter = SafeAdapter()


        binding.recyclerView.apply{
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = this@MainActivity.adapter
            this.setHasFixedSize(true)
        }

        viewModel.getList(API_KEY) //view가 viewmodel로부터 데이터를 받아오는 과정
        viewModel.safe.observe(this){
            if (it.isSuccessful){
                adapter.submitList(it.body()?.pharmListViewInfo!!.row)

            }
        }

    }
}