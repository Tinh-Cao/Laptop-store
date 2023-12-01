/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessList;

import java.util.List;
/**
 *
 * @author tungl
 */
import DTO.ProductDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortList {

    public List<ProductDTO> sortPrice(List<ProductDTO> list, int mode) {
        if (mode == 1) {
            // Sắp xếp theo giá giảm dần
            Collections.sort(list, new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO p1, ProductDTO p2) {
                    return Double.compare(p2.getPrice(), p1.getPrice());
                }
            });
        } else if (mode == 2) {
            // Sắp xếp theo giá tăng dần
            Collections.sort(list, new Comparator<ProductDTO>() {
                @Override
                public int compare(ProductDTO p1, ProductDTO p2) {
                    return Double.compare(p1.getPrice(), p2.getPrice());
                }
            });
        }
        return list;
    }

    public List<ProductDTO> filterByPrice(List<ProductDTO> list, double p) {
        List<ProductDTO> filteredList = new ArrayList<>();

        for (ProductDTO i : list) {

            if (i.getPrice() >= (p - 100) && i.getPrice() <= p) {
                filteredList.add(i);
            }
        }

        return filteredList;
    }

}
