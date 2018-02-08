package net.blockchaind.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import net.blockchaind.swoosh.Model.Player
import net.blockchaind.swoosh.R
import net.blockchaind.swoosh.Utilities.EXTRA_PLAYER

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchText.text = "Looking for ${player.league} ${player.skill} league near you..."
    }
}
