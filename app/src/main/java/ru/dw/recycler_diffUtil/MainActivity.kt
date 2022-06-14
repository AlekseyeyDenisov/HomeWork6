package ru.dw.recycler_diffUtil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.dw.recycler_diffUtil.presentation.RecyclerFragment
import ru.dw.to_dolist.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecyclerFragment.newInstance())
                .commitNow()
        }
    }
}