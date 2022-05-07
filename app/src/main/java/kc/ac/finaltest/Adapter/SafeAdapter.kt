package kc.ac.finaltest.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kc.ac.finaltest.databinding.ItemListBinding
import kc.ac.finaltest.remote.Row

class SafeAdapter : RecyclerView.Adapter<SafeAdapter.SafeViewHolder>()
{
    private val safeList = mutableListOf<Row>()

    //notifyDataSetchanged 리스트의 크기와 아이템이 둘다 변경되는 경우에 사용
    @SuppressLint("NotifyDataSetChanged")
    fun submitList(item : List<Row>) {
        safeList.clear()
        safeList.addAll(item)
        notifyDataSetChanged()
    }

    inner class SafeViewHolder(private val binding : ItemListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Row) {
            binding.safe = item
        }
    }

    //viewHolder 생성하는 부분
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SafeAdapter.SafeViewHolder {

        return SafeViewHolder(ItemListBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    // 데이터와 ViewHolder를 연결 시켜주는 부분
    override fun onBindViewHolder(holder: SafeAdapter.SafeViewHolder, position: Int) {
        val item = safeList[position]
        holder.bind(item)
    }

    //받아온 데이터의 크기를 받는 부분
    override fun getItemCount(): Int = safeList.size
}