# Procedural Name Generator

Java program which generates names based on a file with one name per line.

After instantiating the NameGenrator, use the setFileToUse(FILE_PATH) method to set up the source of the proc generated names.
This method fills three arrays with beginning syllables, middle syllables, and end syllables. These are not true syllables, but
rather chunks of a names with lengths of 2, 3, or 4 letters. All beiginning syllables start with an upper case letter. 

This program produces names by stitching together these chunks randomly, sometimes omitting the middle syllable.

# Results
Here are some of the names generated from common names :

    Broaly
    Mekhzer
    Osere
    Nildnissrie
    Mordumn
    Yeszhu
    Lynerro
    Mignilla
    Brocyl
    Yusrol
    Ediss
    Dednia
    Saryj
    Ahmobia
    Ulyyana
    Aureoll
    Keifdsto
    Otelnnelco
    Ravston

Here are some names generated from Tolkien names :

    Fastmanos
    Turbard   
    Panbu
    Alabold
    Mahldi
    Lécw
    Panffo
    Dafar
    Mablroddhon
    Gwllon
    Barasui
    Togiga
    Samwdan
    Primeht
    Urthor
    Tarcawi
    Andwfan
    Milicctho
    Tullfanwen
    Folthys
    Ae-Ata

[Here](https://raw.githubusercontent.com/hadley/data-baby-names/master/baby-names.csv) i found a CSV of names which i parsed out into the first_names file found in this repo.

[Here](https://github.com/juandes/lotr-names-classification) is where i pulled the CSV of the Tolkien names which i parsed out into the parsed_lotr_names.

