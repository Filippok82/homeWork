package tree;

import human.Human;
import relative.Relative;

import java.util.ArrayList;

public class Node {
    Human person1;
    private Relative re;
    Human person2;


    public ArrayList<Node> tree = new ArrayList<>();
    public ArrayList<Node> listHuman = new ArrayList<>();
    public Node(Human person1, Relative re, Human person2) {

        this.person1 = person1;
        this.re = re;
        this.person2 = person2;

    }

    public Node() {
       this.person1 = getPerson1();
    }

    public Node(Human person1) {
        this.person1 =person1;
    }


    public ArrayList<Node> getTree() {
        return tree;
    }


    public void append(Human parent, Human children) {
        tree.add(new Node(parent, Relative.parent, children));
        tree.add(new Node(children, Relative.children, parent));
    }



    public Human getPerson1() {
        return person1;
    }

    public Relative getRe() {
        return re;
    }

    public Human getPerson2() {
        return person2;
    }

    public void addHuman(Human person1){
        listHuman.add(new Node(person1));
    }

    public String toString() {
        return String.format("<%s | %s | %s>\n", person1.getFullName(), re, person2.getFullName());
    }

    public String toFileString() {
        return String.format("%s ", this.getTree());


    }
}