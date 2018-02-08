package net.blockchaind.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import net.blockchaind.swoosh.Model.Player
import net.blockchaind.swoosh.R
import net.blockchaind.swoosh.Utilities.EXTRA_PLAYER

class LeagueActivity : BaseActivity() {
    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onMensClicked(view: View) {
        womenBtn.isChecked = false
        coedBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomenClicked(view: View) {
        mensBtn.isChecked = false
        coedBtn.isChecked = false

        player.league = "women"
    }

    fun onCoedClicked(view: View) {
        womenBtn.isChecked = false
        mensBtn.isChecked = false

        player.league = "coed"
    }

    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER,player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this,"Please select a league",Toast.LENGTH_LONG).show()
        }
    }
}
