package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(String.format(
                    "Could not way by diagonal from %s to %s", position, dest));
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int x = position.getX();
        int y = position.getY();
        for (int i = 0; i < size; i++) {
            x += (dest.getX() - x > 0) ? 1 : -1;
            y += (dest.getY() - y > 0) ? 1 : -1;
            steps[i] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (dest.getX() - source.getX()) == dest.getY() - source.getY();
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
