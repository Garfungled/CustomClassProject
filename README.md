This is a project for my AP Java class, thus, we are extremely limited in the Java features we're allowed to use (arrays, arraylists, etc). Thus, this code isn't "optimized". I'm simply testing how far I can get with the tools I'm given.

# ROOT filing system

`ROOT` is a filing system in which every `Folder` has at most 3 subfolders and 3 subfiles. Using a *HAS A* relationship, a folder *HAS A* subfolder and that subfolder *HAS A* subsubfolder, and so on. This is similar to how a linked-list in C works. This allows for infinite expansion. A `File` is only a parent class and only serves as a base for file extensions. For example, `DOTjava` is the class representing the file type `file.java`.

## Class Structure

![class structure picture](https://yuml.me/fishdrowned/ROOT.png)