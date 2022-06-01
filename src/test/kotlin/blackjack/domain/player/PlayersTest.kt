package blackjack.domain.player

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class PlayersTest : StringSpec({
    "참가자들을 생성할수 있다." {
        shouldNotThrow<Throwable> { Players(listOf(Player.sit(Name("dean")), Player.sit(Name("dane")))) }
    }

    "참가자 수가 2명 미만일 경우 Exception을 던진다." {
        val players = listOf(
            listOf(Player.sit(Name("dean"))),
            emptyList()
        )

        players.forAll {
            shouldThrow<IllegalArgumentException> {
                Players(it)
            }
        }
    }
})
