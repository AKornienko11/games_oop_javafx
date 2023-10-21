package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell pos  = bishopBlack.position();
        Cell expected = Cell.D4;
        assertThat(pos).isEqualTo(expected);

    }

    @Test
    public void copy() {
       BishopBlack bishopBlack = new BishopBlack(Cell.B6);
        Figure figure = bishopBlack.copy(Cell.B6);
        Cell expected = Cell.B6;
        assertThat(figure.position()).isEqualTo(expected);

    }

    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] figure = bishopBlack.way(Cell.G5);
        Cell[] expected = new Cell[] { Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(figure).isEqualTo(expected);

    }

    @Test
    public void wayIncludeException()  {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,() -> {
            bishopBlack.way(Cell.G6);
        });
        assertThat(exception.getMessage()).isEqualTo(String.format
                ("Could not way by diagonal from %s to %s", Cell.C1, Cell.G6));


    }



}