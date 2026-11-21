package model;

import java.util.ArrayList;
import java.util.List;

public class RecursiveAlgorithms {

    // Recursive Merge Sort
    public static List<StaffMember> mergeSort(List<StaffMember> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<StaffMember> left = mergeSort(new ArrayList<>(list.subList(0, mid)));
        List<StaffMember> right = mergeSort(new ArrayList<>(list.subList(mid, list.size())));

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

    // Recursive Binary Search
    public static StaffMember recursiveBinarySearch(List<StaffMember> sortedList, String targetName, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        StaffMember midMember = sortedList.get(mid);
        int comparison = midMember.getName().compareToIgnoreCase(targetName.trim());

        if (comparison == 0) {
            return midMember;
        } else if (comparison > 0) {
            return recursiveBinarySearch(sortedList, targetName, low, mid - 1);
        } else {
            return recursiveBinarySearch(sortedList, targetName, mid + 1, high);
        }
    }
}
    
