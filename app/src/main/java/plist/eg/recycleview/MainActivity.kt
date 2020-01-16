package plist.eg.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

class ListFragment(): Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)

        val items = mutableListOf<String>()
        for (i in 1..1000) {
            items.add("${UUID.randomUUID()}")
        }

        val rView: RecyclerView = view.findViewById(R.id.container)
        rView.layoutManager = LinearLayoutManager(view.context)
        rView.adapter = Adapter(items)

        return view
    }
}

class ListItemView(itemView: View): RecyclerView.ViewHolder(itemView) {
    var textView: TextView
    init {
        textView = itemView.findViewById(R.id.itemText)
    }

    var text: CharSequence
        get() = textView.text
        set(value) {
            textView.text = value
        }
}

class Adapter(val list: List<String>): RecyclerView.Adapter<ListItemView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemView {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListItemView(itemView)
    }

    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(holder: ListItemView, position: Int) {
        holder.text = list[position]
    }

}