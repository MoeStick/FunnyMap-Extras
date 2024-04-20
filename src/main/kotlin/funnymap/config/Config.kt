package funnymap.config

import funnymap.FunnyMap
import funnymap.ui.EditLocationGui
import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.*
import java.awt.Color
import java.io.File

object Config : Vigilant(File("./config/funnymap/config.toml"), "Funny Map", sortingBehavior = CategorySorting) {

    @Property(
        name = "Map Enabled",
        type = PropertyType.SWITCH,
        description = "Render the map!",
        category = "Map",
        subcategory = "Toggle"
    )
    var mapEnabled = true

    @Property(
        name = "Rotate Map",
        type = PropertyType.SWITCH,
        description = "Rotates map to follow the player.",
        category = "Map",
        subcategory = "Toggle"
    )
    var mapRotate = false

    @Property(
        name = "Center Map",
        type = PropertyType.SWITCH,
        description = "Centers the map on the player if Rotate Map is enabled.",
        category = "Map",
        subcategory = "Toggle"
    )
    var mapCenter = false

    @Property(
        name = "Dynamic Rotate",
        type = PropertyType.SWITCH,
        description = "Keeps the entrance room at the bottom. Does not work with rotate map.",
        category = "Map",
        subcategory = "Toggle"
    )
    var mapDynamicRotate = false

    @Property(
        name = "Hide In Boss",
        type = PropertyType.SWITCH,
        description = "Hides the map in boss.",
        category = "Map",
        subcategory = "Toggle"
    )
    var mapHideInBoss = false

    @Property(
        name = "Show Player Names",
        type = PropertyType.SELECTOR,
        description = "Show player name under player head",
        category = "Map",
        subcategory = "Toggle",
        options = ["Off", "Holding Leap", "Always"]
    )
    var playerHeads = 0

    @Property(
        name = "Vanilla Head Marker",
        type = PropertyType.SWITCH,
        description = "Uses the vanilla head marker for yourself.",
        category = "Map",
        subcategory = "Toggle"
    )
    var mapVanillaMarker = false

    @Property(
        name = "Auto Scan",
        type = PropertyType.SWITCH,
        description = "Automatically scans when entering dungeon. Manual scan can be done with \"/fmap scan\"",
        category = "Map",
        subcategory = "Scanning"
    )
    var autoScan = true

    @Property(
        name = "Chat Info",
        type = PropertyType.SWITCH,
        description = "Show dungeon overview information after scanning.",
        category = "Map",
        subcategory = "Scanning"
    )
    var scanChatInfo = true

    @Property(
        name = "Map Position",
        type = PropertyType.BUTTON,
        category = "Map",
        subcategory = "Size",
        placeholder = "Edit"
    )
    fun openMoveMapGui() {
        FunnyMap.display = EditLocationGui()
    }

    @Property(
        name = "Reset Map Position",
        type = PropertyType.BUTTON,
        category = "Map",
        subcategory = "Size",
        placeholder = "Reset"
    )
    fun resetMapLocation() {
        mapX = 10
        mapY = 10
    }

    @Property(
        name = "Map X",
        type = PropertyType.NUMBER,
        category = "Map",
        subcategory = "Size",
        hidden = true
    )
    var mapX = 10

    @Property(
        name = "Map Y",
        type = PropertyType.NUMBER,
        category = "Map",
        subcategory = "Size",
        hidden = true
    )
    var mapY = 10

    @Property(
        name = "Map Size",
        type = PropertyType.DECIMAL_SLIDER,
        description = "Scale of entire map.",
        category = "Map",
        subcategory = "Size",
        minF = 0.1f,
        maxF = 4f,
        decimalPlaces = 2,
        hidden = true
    )
    var mapScale = 1.25f

    @Property(
        name = "Map Text Scale",
        type = PropertyType.DECIMAL_SLIDER,
        description = "Scale of room names and secret counts relative to map size.",
        category = "Map",
        subcategory = "Size",
        maxF = 2f,
        decimalPlaces = 2
    )
    var textScale = 0.75f

    @Property(
        name = "Player Heads Scale",
        type = PropertyType.DECIMAL_SLIDER,
        description = "Scale of player heads relative to map size.",
        category = "Map",
        subcategory = "Size",
        maxF = 2f,
        decimalPlaces = 2
    )
    var playerHeadScale = 1f

    @Property(
        name = "Player Name Scale",
        type = PropertyType.DECIMAL_SLIDER,
        description = "Scale of player names relative to head size.",
        category = "Map",
        subcategory = "Size",
        maxF = 2f,
        decimalPlaces = 2
    )
    var playerNameScale = .8f

    @Property(
        name = "Map Background Color",
        type = PropertyType.COLOR,
        category = "Map",
        subcategory = "Render",
        allowAlpha = true
    )
    var mapBackground = Color(0, 0, 0, 100)

    @Property(
        name = "Map Border Color",
        type = PropertyType.COLOR,
        category = "Map",
        subcategory = "Render",
        allowAlpha = true
    )
    var mapBorder = Color(0, 0, 0, 255)

    @Property(
        name = "Border Thickness",
        type = PropertyType.DECIMAL_SLIDER,
        category = "Map",
        subcategory = "Render",
        maxF = 10f
    )
    var mapBorderWidth = 3f

    @Property(
        name = "Dark Undiscovered Rooms",
        type = PropertyType.SWITCH,
        description = "Darkens unentered rooms.",
        category = "Rooms"
    )
    var mapDarkenUndiscovered = true

    @Property(
        name = "Gray Undiscovered Rooms",
        type = PropertyType.SWITCH,
        description = "Darkens unentered rooms.",
        category = "Rooms"
    )
    var mapGrayUndiscovered = true

    @Property(
        name = "Room Names",
        type = PropertyType.SELECTOR,
        description = "Shows names of rooms on map.",
        category = "Rooms",
        options = ["None", "Puzzles / Trap", "All"]
    )
    var mapRoomNames = 1

    @Property(
        name = "Room Secrets",
        type = PropertyType.SELECTOR,
        description = "Shows total secrets of rooms on map.",
        category = "Rooms",
        options = ["Off", "On", "Replace Checkmark"]
    )
    var mapRoomSecrets = 0

    @Property(
        name = "Color Text",
        type = PropertyType.SWITCH,
        description = "Colors name and secret count based on room state.",
        category = "Rooms"
    )
    var mapColorText = false

    @Property(
        name = "Room Checkmarks",
        type = PropertyType.SELECTOR,
        description = "Adds room checkmarks based on room state.",
        category = "Rooms",
        options = ["None", "Default", "NEU"]
    )
    var mapCheckmark = 1

    @Property(
        name = "Darken Multiplier",
        type = PropertyType.PERCENT_SLIDER,
        description = "How much to darken undiscovered rooms",
        category = "Colors"
    )
    var mapDarkenPercent = 0.4f

    @Property(
        name = "Blood Door",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Doors",
        allowAlpha = true
    )
    var colorBloodDoor = Color(231, 0, 0)

    @Property(
        name = "Entrance Door",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Doors",
        allowAlpha = true
    )
    var colorEntranceDoor = Color(20, 133, 0)

    @Property(
        name = "Normal Door",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Doors",
        allowAlpha = true
    )
    var colorRoomDoor = Color(92, 52, 14)

    @Property(
        name = "Wither Door",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Doors",
        allowAlpha = true
    )
    var colorWitherDoor = Color(0, 0, 0)

    @Property(
        name = "Opened Wither Door",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Doors",
        allowAlpha = true
    )
    var colorOpenWitherDoor = Color(92, 52, 14)

    @Property(
        name = "Blood Room",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Rooms",
        allowAlpha = true
    )
    var colorBlood = Color(255, 0, 0)

    @Property(
        name = "Entrance Room",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Rooms",
        allowAlpha = true
    )
    var colorEntrance = Color(20, 133, 0)

    @Property(
        name = "Fairy Room",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Rooms",
        allowAlpha = true
    )
    var colorFairy = Color(224, 0, 255)

    @Property(
        name = "Miniboss Room",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Rooms",
        allowAlpha = true
    )
    var colorMiniboss = Color(254, 223, 0)

    @Property(
        name = "Normal Room",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Rooms",
        allowAlpha = true
    )
    var colorRoom = Color(107, 58, 17)

    @Property(
        name = "Mimic Room",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Rooms",
        allowAlpha = true
    )
    var colorRoomMimic = Color(186, 66, 52)

    @Property(
        name = "Puzzle Room",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Rooms",
        allowAlpha = true
    )
    var colorPuzzle = Color(117, 0, 133)

    @Property(
        name = "Rare Room",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Rooms",
        allowAlpha = true
    )
    var colorRare = Color(255, 203, 89)

    @Property(
        name = "Trap Room",
        type = PropertyType.COLOR,
        category = "Colors",
        subcategory = "Rooms",
        allowAlpha = true
    )
    var colorTrap = Color(216, 127, 51)

    @Property(
        name = "Show Score",
        type = PropertyType.SWITCH,
        category = "Score",
        subcategory = "Toggle"
    )
    var scoreElementEnabled = false

    @Property(
        name = "Assume Spirit",
        type = PropertyType.SWITCH,
        category = "Score",
        subcategory = "Toggle"
    )
    var scoreAssumeSpirit = true

    @Property(
        name = "Minimized Text",
        description = "Shortens description for score elements.",
        type = PropertyType.SWITCH,
        category = "Score",
        subcategory = "Toggle"
    )
    var scoreMinimizedName = false

    @Property(
        name = "Hide in Boss",
        type = PropertyType.SWITCH,
        category = "Score",
        subcategory = "Toggle"
    )
    var scoreHideInBoss = false

    @Property(
        name = "Score Calc X",
        type = PropertyType.NUMBER,
        category = "Score",
        subcategory = "Size",
        hidden = true
    )
    var scoreX = 10

    @Property(
        name = "Score Calc Y",
        type = PropertyType.NUMBER,
        category = "Score",
        subcategory = "Size",
        hidden = true
    )
    var scoreY = 10

    @Property(
        name = "Score Calc Size",
        type = PropertyType.DECIMAL_SLIDER,
        description = "Scale of score calc.",
        category = "Score",
        subcategory = "Size",
        minF = 0.1f,
        maxF = 4f,
        decimalPlaces = 2,
        hidden = true
    )
    var scoreScale = 1f

    @Property(
        name = "Score",
        type = PropertyType.SELECTOR,
        category = "Score",
        subcategory = "Elements",
        options = ["Off", "On", "Separate"]
    )
    var scoreTotalScore = 2

    @Property(
        name = "Secrets",
        type = PropertyType.SELECTOR,
        category = "Score",
        subcategory = "Elements",
        options = ["Off", "Total", "Total and Missing"]
    )
    var scoreSecrets = 1

    @Property(
        name = "Crypts",
        type = PropertyType.SWITCH,
        category = "Score",
        subcategory = "Elements"
    )
    var scoreCrypts = false

    @Property(
        name = "Mimic",
        type = PropertyType.SWITCH,
        category = "Score",
        subcategory = "Elements"
    )
    var scoreMimic = false

    @Property(
        name = "Deaths",
        type = PropertyType.SWITCH,
        category = "Score",
        subcategory = "Elements"
    )
    var scoreDeaths = false

    @Property(
        name = "Puzzles",
        type = PropertyType.SELECTOR,
        category = "Score",
        subcategory = "Elements",
        options = ["Off", "Total", "Completed and Total"]
    )
    var scorePuzzles = 0

    @Property(
        name = "Score Messages",
        type = PropertyType.SELECTOR,
        category = "Score",
        subcategory = "Message",
        options = ["Off", "300", "270 and 300"]
    )
    var scoreMessage = 0

    @Property(
        name = "Score Title",
        description = "Shows score messages as a title notification.",
        type = PropertyType.SELECTOR,
        category = "Score",
        subcategory = "Message",
        options = ["Off", "300", "270 and 300"]
    )
    var scoreTitle = 0

    @Property(
        name = "270 Message",
        type = PropertyType.TEXT,
        category = "Score",
        subcategory = "Message"
    )
    var message270 = "270 Score"

    @Property(
        name = "300 Message",
        type = PropertyType.TEXT,
        category = "Score",
        subcategory = "Message"
    )
    var message300 = "300 Score"

    @Property(
        name = "300 Time",
        type = PropertyType.SWITCH,
        category = "Score",
        subcategory = "Message"
    )
    var timeTo300 = false

    @Property(
        name = "Show Run Information",
        type = PropertyType.SWITCH,
        description = "Shows run information under map.",
        category = "Run Information",
        subcategory = "Toggle"
    )
    var mapShowRunInformation = true

    @Property(
        name = "Score",
        type = PropertyType.SWITCH,
        category = "Run Information",
        subcategory = "Elements"
    )
    var runInformationScore = true

    @Property(
        name = "Secrets",
        type = PropertyType.SELECTOR,
        category = "Run Information",
        subcategory = "Elements",
        options = ["Off", "Total", "Total and Missing"]
    )
    var runInformationSecrets = 1

    @Property(
        name = "Crypts",
        type = PropertyType.SWITCH,
        category = "Run Information",
        subcategory = "Elements"
    )
    var runInformationCrypts = true

    @Property(
        name = "Mimic",
        type = PropertyType.SWITCH,
        category = "Run Information",
        subcategory = "Elements"
    )
    var runInformationMimic = true

    @Property(
        name = "Deaths",
        type = PropertyType.SWITCH,
        category = "Run Information",
        subcategory = "Elements"
    )
    var runInformationDeaths = true

    @Property(
        name = "Hypixel API Key",
        type = PropertyType.TEXT,
        category = "Other Features",
        protectedText = true
    )
    var apiKey = ""

    @Property(
        name = "Show Team Info",
        description = "Shows team member secrets and room times at end of run. Requires a valid API key.",
        type = PropertyType.SWITCH,
        category = "Other Features"
    )
    var teamInfo = false

    @Property(
        name = "Mimic Message",
        type = PropertyType.SWITCH,
        category = "Other Features",
        subcategory = "Mimic Message"
    )
    var mimicMessageEnabled = false

    @Property(
        name = "Mimic Message Text",
        type = PropertyType.TEXT,
        category = "Other Features",
        subcategory = "Mimic Message"
    )
    var mimicMessage = "Mimic Killed!"

    @Property(
        name = "Wither Door ESP",
        description = "Boxes unopened wither doors.",
        type = PropertyType.SELECTOR,
        category = "Other Features",
        subcategory = "Wither Door",
        options = ["Off", "First", "All"]
    )
    var witherDoorESP = 0

    @Property(
        name = "No Key Color",
        type = PropertyType.COLOR,
        category = "Other Features",
        subcategory = "Wither Door",
        allowAlpha = true
    )
    var witherDoorNoKeyColor = Color(255, 0, 0)

    @Property(
        name = "Has Key Color",
        type = PropertyType.COLOR,
        category = "Other Features",
        subcategory = "Wither Door",
        allowAlpha = true
    )
    var witherDoorKeyColor = Color(0, 255, 0)

    @Property(
        name = "Outline Width",
        type = PropertyType.DECIMAL_SLIDER,
        category = "Other Features",
        subcategory = "Wither Door",
        minF = 1f,
        maxF = 10f
    )
    var witherDoorOutlineWidth = 3f

    @Property(
        name = "Outline Opacity",
        type = PropertyType.PERCENT_SLIDER,
        category = "Other Features",
        subcategory = "Wither Door"
    )
    var witherDoorOutline = 1f

    @Property(
        name = "Fill Opacity",
        type = PropertyType.PERCENT_SLIDER,
        category = "Other Features",
        subcategory = "Wither Door"
    )
    var witherDoorFill = 0.25f

    @Property(
        name = "Force Skyblock",
        type = PropertyType.SWITCH,
        category = "Debug"
    )
    var forceSkyblock = false

    @Property(
        name = "Paul Score",
        description = "Assumes paul perk is active to give 10 bonus score.",
        type = PropertyType.SWITCH,
        category = "Debug"
    )
    var paulBonus = false

    init {
        initialize()
        setCategoryDescription(
            "Map", "&f&l Funny Map\n&7Big thanks to &lIllegalMap&r&7 by UnclaimedBloom"
        )
    }

    private object CategorySorting : SortingBehavior() {

        private val configCategories = listOf(
            "Map", "Rooms", "Run Information", "Score", "Colors", "Other Features", "Debug"
        )

        private val configSubcategories = listOf(
            "Toggle", "Elements", "Scanning", "Size", "Render"
        )

        override fun getCategoryComparator(): Comparator<in Category> = compareBy { configCategories.indexOf(it.name) }

        override fun getSubcategoryComparator(): Comparator<in Map.Entry<String, List<PropertyData>>> =
            compareBy { configSubcategories.indexOf(it.key) }
    }
}
