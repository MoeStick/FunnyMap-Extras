package funnymap.ui

import funnymap.FunnyMap.Companion.config
import funnymap.FunnyMap.Companion.mc
import funnymap.features.dungeon.RunInformation
import funnymap.features.dungeon.ScoreCalculation
import funnymap.utils.Location
import net.minecraft.client.gui.FontRenderer

class ScoreElement : MovableGuiElement() {
    override var x: Int by config::scoreX
    override var y: Int by config::scoreY
    override val h: Int
        get() = fr.FONT_HEIGHT * elementLines
    override val w: Int = fr.getStringWidth("Score: 100/100/100/7 : (300)")
    override var scale: Float by config::scoreScale
    override var x2: Int = (x + w * scale).toInt()
    override var y2: Int = (y + h * scale).toInt()

    private var elementLines = 1
        set(value) {
            if (field != value) {
                field = value
                y2 = (y + h * scale).toInt()
            }
        }

    override fun render() {
        var y = 0f
        val lines = getScoreLines()
        elementLines = lines.size
        lines.forEach {
            fr.drawString(it, 0f, y, 0xffffff, true)
            y += fr.FONT_HEIGHT
        }
    }

    override fun shouldRender(): Boolean {
        if (!config.scoreElementEnabled) return false
        if (config.scoreHideInBoss && Location.inBoss) return false
        return super.shouldRender()
    }

    companion object {
        val fr: FontRenderer = mc.fontRendererObj

        fun getScoreLines(): List<String> {
            val list: MutableList<String> = mutableListOf()

            when (config.scoreTotalScore) {
                1 -> list.add(getScore(config.scoreMinimizedName, false))
                2 -> list.add(getScore(config.scoreMinimizedName, true))
            }

            when (config.scoreSecrets) {
                1 -> list.add(getSecrets(config.scoreMinimizedName, false))
                2 -> list.add(getSecrets(config.scoreMinimizedName, true))
            }

            if (config.scoreCrypts) {
                list.add(getCrypts(config.scoreMinimizedName))
            }

            if (config.scoreMimic) {
                list.add(getMimic(config.scoreMinimizedName))
            }

            if (config.scoreDeaths) {
                list.add(getDeaths(config.scoreMinimizedName))
            }

            when (config.scorePuzzles) {
                1 -> list.add(getPuzzles(config.scoreMinimizedName, false))
                2 -> list.add(getPuzzles(config.scoreMinimizedName, true))
            }

            return list
        }

        fun runInformationLines(): List<String> {
            val list: MutableList<String> = mutableListOf()

            if (config.runInformationScore) {
                list.add(getScore(minimized = false, expanded = false))
            }

            when (config.runInformationSecrets) {
                1 -> list.add(getSecrets(minimized = false, missing = false))
                2 -> list.add(getSecrets(minimized = false, missing = true))
            }

            list.add("split")

            if (config.runInformationCrypts) {
                list.add(getCrypts())
            }

            if (config.runInformationMimic) {
                list.add(getMimic())
            }

            if (config.runInformationDeaths) {
                list.add(getDeaths())
            }

            return list
        }

        private fun getScore(minimized: Boolean = false, expanded: Boolean): String {
            val scoreColor = when {
                ScoreCalculation.score < 270 -> "§c"
                ScoreCalculation.score < 300 -> "§e"
                else -> "§a"
            }
            var line = if (minimized) "" else "§7Score: "
            if (expanded) {
                line += "§b${ScoreCalculation.getSkillScore()}§7/" +
                        "§a${ScoreCalculation.getExplorationScore()}§7/" +
                        "§3${ScoreCalculation.getSpeedScore(RunInformation.timeElapsed)}§7/" +
                        "§d${ScoreCalculation.getBonusScore()} §7: "
            }
            line += "$scoreColor${ScoreCalculation.score}"

            return line
        }

        private fun getSecrets(minimized: Boolean = false, missing: Boolean): String {
            var line = if (minimized) "" else "§7Secrets: "
            line += "§b${RunInformation.secretsFound}§7/"
            if (missing) {
                val missingSecrets = (RunInformation.minSecrets - RunInformation.secretsFound).coerceAtLeast(0)
                line += "§e${missingSecrets}§7/"
            }
            line += "§c${RunInformation.secretTotal}"

            return line
        }

        private fun getCrypts(minimized: Boolean = false): String {
            var line = if (minimized) "§7C: " else "§7Crypts: "
            line += if (RunInformation.cryptsCount >= 5) "§a${RunInformation.cryptsCount}" else "§c${RunInformation.cryptsCount}"
            return line
        }

        private fun getMimic(minimized: Boolean = false): String {
            var line = if (minimized) "§7M: " else "§7Mimic: "
            line += if (RunInformation.mimicKilled) "§a✔" else "§c✘"
            return line
        }

        private fun getDeaths(minimized: Boolean = false): String {
            var line = if (minimized) "§7D: " else "§7Deaths: "
            line += "§c${RunInformation.deathCount}"
            return line
        }

        private fun getPuzzles(minimized: Boolean = false, total: Boolean): String {
            val color = if (RunInformation.completedPuzzles == RunInformation.totalPuzzles) "§a" else "§c"
            var line = if (minimized) "§7P: " else "§7Puzzles: "
            line += "$color${RunInformation.completedPuzzles}"
            if (total) line += "§7/$color${RunInformation.totalPuzzles}"
            return line
        }
    }
}
