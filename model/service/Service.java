package model.service;

import model.human.Gender;
import model.human.Human;
import model.tree.Compilation;
import model.tree.GeoTree;
import model.tree.humanGroup.HumanGroupItem;
import model.tree.humanGroup.ListAllHuman;
import model.tree.relative.Relative;
import model.workingWithFile.FileData;

import java.time.LocalDate;
import java.util.ArrayList;


public class Service<E extends HumanGroupItem> {
    private ListAllHuman<E> listAllHuman;
    private GeoTree<String> treeNode;
    private Compilation compilation;
    private FileData file;
    private Relative rel;

    public Service() {

        listAllHuman = new ListAllHuman<>();
        treeNode = new GeoTree();
        file = new FileData();
        compilation = new Compilation(treeNode);
    }


    public String getHumanList() {
        StringBuilder builder = new StringBuilder();
        for (E human : listAllHuman) {
            builder.append(human);
            builder.append("\n");
        }
        return builder.toString();
    }

    public String sortByName() {
        listAllHuman.sortByName();
        return getHumanList();
    }

    public ListAllHuman<E> getListAllHuman() {
        return listAllHuman;
    }

    public String sortByAge() {
        listAllHuman.sortByAge();
        return getHumanList();
    }


    public String addHumans(String name, String genderHuman, String birthDate) {
        Gender gender = Gender.valueOf(genderHuman);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate);
        listAllHuman.addHumans((E) human);
        return "Человек успешно добавлен в дерево";
    }

    public String searchByName(String name) {
        for (E lst : listAllHuman) {
            if (lst.getFullName().equals(name)) {
                return name;
            }
        }
        return "Имя не найдено";
    }

    public ArrayList familyNode(String parent, String children) {
        treeNode.append(parent,children);
        return treeNode.getTree();
    }

    public String familyСollection(String person, String relative) {
        Relative rel = Relative.valueOf(relative);
        compilation.printSearch(person.toString(), rel);
        return compilation.toString();
    }

    public String familyTreeEntry(String path) {
        file.add(treeNode, path);
        return "Запись в файл";

    }

    public String familyTreeRead(String path) {
        file.load(path);
        return file.toString();
    }


}
