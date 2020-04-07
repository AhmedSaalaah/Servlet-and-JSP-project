package DataBase;

/**
 *
 * @author ramr
 */
public class Insert {

    Database2 db = new Database2();
    int x0 = db.insert_product("Huawei-nova-5i", 2000, "mobiles", "Images/huawei-nova-5i-pro.jpg", "Dimensions	156.1 x 73.9 x 8.3 mm (6.15 x 2.91 x 0.33 in)\n"
            + "Weight	178 g (6.28 oz)\n"
            + "Build	Glass front, plastic back, plastic frame\n"
            + "SIM	Hybrid Dual SIM (Nano-SIM, dual stand-by)", 1);
    int x1 = db.insert_product("Huawei-mate30-pro ", 3000, "mobiles", "Images/huawei-mate30-.jpg", "Dimensions	160.8 x 76.1 x 8.4 mm (6.33 x 3.00 x 0.33 in)\n"
            + "Weight	196 g (6.91 oz)\n"
            + "Build	Glass front, glass back, aluminum frame\n"
            + "SIM	Single SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)\n"
            + " 	IP53 dust and splash protection", 10);

    int x2 = db.insert_product("Huawei-y9-prime", 2500, "mobiles", "Images/huawei-y9-prime-2019-.jpg", "Dimensions	160.8 x 76.1 x 8.4 mm (6.33 x 3.00 x 0.33 in)\n"
            + "Weight	196 g (6.91 oz)\n"
            + "Build	Glass front, glass back, aluminum frame\n"
            + "SIM	Single SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)\n"
            + " 	IP53 dust and splash protection", 10);

    int x3 = db.insert_product("Huawei-nova-5t", 2500, "mobiles", "Images/huawei-nova-5t.jpg", "Dimensions	160.8 x 76.1 x 8.4 mm (6.33 x 3.00 x 0.33 in)\n"
            + "Weight	196 g (6.91 oz)\n"
            + "Build	Glass front, glass back, aluminum frame\n"
            + "SIM	Single SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)\n"
            + " 	IP53 dust and splash protection", 10);

    int x4 = db.insert_product("Huawei-nova-4", 2200, "mobiles", "Images/huawei-nova-4-.jpg", "Dimensions	160.8 x 76.1 x 8.4 mm (6.33 x 3.00 x 0.33 in)\n"
            + "Weight	196 g (6.91 oz)\n"
            + "Build	Glass front, glass back, aluminum frame\n"
            + "SIM	Single SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)\n"
            + " 	IP53 dust and splash protection", 10);

    int x5 = db.insert_product("Huawei-y7-prime", 2000, "mobiles", "Images/huawei-y7-prime-2019.jpg", "Dimensions	158.9 x 76.9 x 8.1 mm (6.26 x 3.03 x 0.32 in)\n"
            + "Weight	168 g (5.93 oz)\n"
            + "Build	Glass front, plastic back, plastic frame\n"
            + "SIM	Hybrid Dual SIM (Nano-SIM, dual stand-by)", 10);

    int x6 = db.insert_product("Samsung-galaxy-note10-plus", 10000, "mobiles", "Images/samsung-galaxy-note10-plus-.jpg", "	Dimensions	162.3 x 77.2 x 7.9 mm (6.39 x 3.04 x 0.31 in)\n"
            + "Weight	196 g (6.91 oz)\n"
            + "Build	Glass front (Gorilla Glass 6), glass back (Gorilla Glass 6), aluminum frame\n"
            + "SIM	Single SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)", 10);

    int x7 = db.insert_product("Samsung-galaxy-m11", 9000, "mobiles", "Images/samsung-galaxy-m11-sm-m115.jpg", "Dimensions	161.4 x 76.3 x 9 mm (6.35 x 3.00 x 0.35 in)\n"
            + "Weight	197 g (6.95 oz)\n"
            + "Build	Glass front, plastic back, plastic frame\n"
            + "SIM	Dual SIM (Nano-SIM, dual stand-by)", 10);

    int x8 = db.insert_product("Samsung-galaxy-s8", 8000, "mobiles", "Images/samsung-galaxy-s8-.jpg", "	Dimensions	148.9 x 68.1 x 8 mm (5.86 x 2.68 x 0.31 in)\n"
            + "Weight	155 g (5.47 oz)\n"
            + "Build	Glass front (Gorilla Glass 5), glass back (Gorilla Glass 5), aluminum frame\n"
            + "SIM	Single SIM (Nano-SIM) or Hybrid Dual SIM (Nano-SIM, dual stand-by)", 10);

    int x9 = db.insert_product("Lenovo V130", 5123, "laptops", "Images/item_L_102052136_6724a4895395d.jpg", "Operating System: windows\n"
            + "Hard Disk Capacity: 1 tb\n"
            + "Processor Family: intel core i3\n"
            + "Screen Size: 15 - 15.9 inch\n"
            + "Memory Size: 4 gb", 5);

    int x10 = db.insert_product("Lenovo 81TK009VED ideapad C340", 9000, "laptops" , "Images/item_L_117707594_e4e80a942bda3.jpg", "Operating System: windows\n"
            + "Hard Disk Capacity: 256 gb\n"
            + "Processor Family: intel 10th generation core i3\n"
            + "Screen Size: 14 - 14.9 inch\n"
            + "Memory Size: 4 gb", 5);

    int x11 = db.insert_product("Lenovo IdeaPad 330", 4000, "laptops", "Images/item_L_65589696_c973919881ade.jpg", "Operating System: dos\n"
            + "Hard Disk Capacity: 1 tb\n"
            + "Processor Family: amd a4 series\n"
            + "Screen Size: 15 - 15.9 inches\n"
            + "Memory Size: 4 gb", 5);

    int x12 = db.insert_product("Lenovo V 130", 5000, "laptops", "Images/item_L_65844125_6710d01b1092a.jpg", "Operating System: dos\n"
            + "Hard Disk Capacity: 1 tb\n"
            + "Processor Family: intel core i3\n"
            + "Screen Size: 15 - 15.9 inches\n"
            + "Memory Size: 4 gb", 5);

    int x13 = db.insert_product("HP Laptop 15-da1885ne", 8500, "laptops" , "Images/item_L_66712870_909707e50ce64.jpg", "Operating System: windows\n"
            + "Hard Disk Capacity: 1 tb\n"
            + "Processor Family: intel 8th generation core i5\n"
            + "Screen Size: 15 - 15.9 inch\n"
            + "Memory Size: 8 gb", 5);

    int x14 = db.insert_product("HP PRO Book 450 G5", 8700, "laptops" , "Images/item_L_49167846_83ba8552543c9.jpg", "Operating System: windows\n"
            + "Hard Disk Capacity: 500 gb\n"
            + "Processor Family: intel 8th generation core i5\n"
            + "Screen Size: 15 - 15.9 inch\n"
            + "Memory Size: 4 gb", 5);

    int x15 = db.insert_product("HP 9EV92EA ABV Pavilion 15", 19000, "laptops" , "Images/item_L_110270193_ba7990649cd9e.jpg", "Operating System: windows\n"
            + "Hard Disk Capacity: 1.256 tb\n"
            + "Processor Family: intel 9th generation core i7\n"
            + "Screen Size: 15 - 15.9 inch\n"
            + "Memory Size: 16 gb", 5);

    public static void main(String[] args) {
        
    }
}
