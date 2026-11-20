package model;

import java.util.ArrayList;
import java.util.List;

public class RecursiveAlgorithms {

    // RECURSIVE MERGE SORT 
    public static List<StaffMember> mergeSort(List<StaffMember> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<StaffMember> left = new ArrayList<>(list.subList(0, mid));
        List<StaffMember> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static List<StaffMember> merge(List<StaffMember> left, List<StaffMember> right) {
        List<StaffMember> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }
}