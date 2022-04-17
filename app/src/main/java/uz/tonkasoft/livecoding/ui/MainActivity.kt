package uz.tonkasoft.livecoding.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.tonkasoft.livecoding.R
import uz.tonkasoft.livecoding.util.Status
import uz.tonkasoft.livecoding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: 1.add recyclerview to main_activity.xml, 2. Use ListAdapter class, DiffUtil, 3. ItemLayout, 4. add  project ViewBinding property Delegate github: kirich1409

        mainViewModel.getBooks()

        mainViewModel.booksLiveData.observe(this) {

            when (it.status) {
                Status.LOADING -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    Toast.makeText(this, "${it.data}", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}