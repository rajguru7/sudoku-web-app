import java.util.ArrayList;
import java.util.Collections;

class Sudoku {
    public int[][] create_grid() {
        int grid[][] = new int[9][9];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<9; i++) 
            list.add(i+1);
        Collections.shuffle(list);
        int nums[] = new int[9];
        for(int i=0; i<9; i++) {
            nums[i] = list.get(i);
        }
        
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                for(int k=0; k<9; k++) {
                    grid[i*3+j][k] = nums[(j*3 + i + k)%9];
                }
            }
        }
        
        return grid;
    }

    public int[][] shuffle_grid(int[][] grid) {

        //creating new order
        int new_order[] = new int[9];
        int len = 0;
        ArrayList<Integer> div = new ArrayList<>();
        for (int i=0; i<3; i++) {
            div.add(i*3);
        }
        Collections.shuffle(div);
        for (int i=0; i<3; i++) {
            int n = div.get(i);
            ArrayList<Integer> list = new ArrayList<>();
            for (int j=0; j<3; j++) 
                list.add(n+j);
            Collections.shuffle(list);
            for (int j=0; j<3; j++) 
                new_order[len++] = list.get(j);
        }
        int[][] new_grid = new int[9][9];
        for (int i=0; i<9; i++) {
            new_grid[i] = grid[new_order[i]];
            //System.out.print(new_order[i]+" ");
        }
        
        return new_grid;
    }

    public void print_grid(int[][] grid) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) 
                System.out.print(grid[i][j]+ " ");
            System.out.println();
        }
    }
    public static void main(String args[]) {
        Sudoku obj = new Sudoku();
        int grid[][] = obj.create_grid();
        //obj.print_grid(grid);
        //System.out.println();
        grid = obj.shuffle_grid(grid);
        //System.out.println();
        //System.out.println();
        obj.print_grid(grid);

    }
}
