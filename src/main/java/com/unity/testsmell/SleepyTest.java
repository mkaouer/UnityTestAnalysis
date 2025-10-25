package com.unity.testsmell;


import com.config.Config;
import com.csharp.astgenerator.SrcmlUnityCsMetaDataGenerator;
import com.github.gumtreediff.tree.ITree;
import com.utility.ProjectPropertyAnalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SleepyTest {

    private boolean sleepFound = false;

    public void getSmell(ITree root)
    {

    }

//    public Map<String,Boolean> searchForSleepyTest(ITree root)
//    {
//        List<ITree> testfunclist=TreeNodeAnalyzer.getTestFunctionList(root);
//        Map<String,Boolean> sleepyTest=new HashMap<>();
//        ITree classnode = SrcmlUnityCsMetaDataGenerator.breadthFirstSearchForNode(root, "class", "c1");
//
//        if(classnode==null)
//            return sleepyTest;
//
//        ITree classname = SrcmlUnityCsMetaDataGenerator.getClassName(classnode);
//
//        String lowerclassname = classname.getLabel();
//
//
//        for(ITree testfunc:testfunclist)
//        {
<<<<<<< HEAD
//            List<ITree> sleepylist=TreeNodeAnalyzer.getSearchTypeLabel(testfunc, "name", "Thread");
=======
//            List<ITree> sleepylist=TreeNodeAnalyzer.getSearchTypeLabel(testfunc, "name", "thread");
>>>>>>> 63cf043761a0e0057ff57ae9d9f2495203e7aa17
//            ITree funcnamenode = SrcmlUnityCsMetaDataGenerator.getFuncName(testfunc);
//            String classtestfunc=lowerclassname+Config.separatorStr+funcnamenode.getLabel();
//
//
//            if(sleepylist!=null && sleepylist.size()>0)
//            {
//                sleepFound = SleepFound(sleepylist);
//            }
//
//            sleepyTest.put(classtestfunc,sleepFound);
//
//
//
//
//
//        }
//
//
//        return sleepyTest;
//
//
//    }

<<<<<<< HEAD
//    public Map<String, Boolean> searchForSleepyTest(ITree root) {
//        List<ITree> testfunclist = TreeNodeAnalyzer.getTestFunctionList(root);
//        Map<String, Boolean> sleepyTest = new HashMap<>();
//        ITree classnode = SrcmlUnityCsMetaDataGenerator.breadthFirstSearchForNode(root, "class", "c1");
//
//        if (classnode == null) return sleepyTest;
//
//        ITree classname = SrcmlUnityCsMetaDataGenerator.getClassName(classnode);
//        String lowerclassname = classname.getLabel();
//
//        for (ITree testfunc : testfunclist) {
//            // Search for the 'Thread' class
//            List<ITree> threadlist = TreeNodeAnalyzer.getSearchTypeLabel(testfunc, "name", "Thread");
//            System.out.println("thread list=>"+threadlist);
//            System.out.println("thread list size=>"+threadlist.size());
//            ITree funcnamenode = SrcmlUnityCsMetaDataGenerator.getFuncName(testfunc);
//            System.out.println("function node=>"+funcnamenode.getLabel());
//            String classtestfunc = lowerclassname + Config.separatorStr + funcnamenode.getLabel();
//
//            boolean sleepFound = false;
//
//            if(threadlist!=null && threadlist.size()>0)
//            {
//                sleepFound = SleepFound(threadlist);
//            }
//
//            sleepyTest.put(classtestfunc, sleepFound);
//        }
//
//        return sleepyTest;
//    }
//
//
//    private boolean SleepFound(List<ITree>foundList) {
//        System.out.println("foundList=>"+foundList);
//        boolean isfound = false;
//
//        for (ITree sleep : foundList) {
//            System.out.println("sleep=>"+sleep.getLabel());
//            if(sleep.getLabel().contains("sleep")) {
//                isfound = true;
//            }
//            else{
//                isfound = false;
//            }
//        }
//        System.out.println("isfound=>"+isfound);
//        return isfound;
//    }

    public Map<String, Boolean> searchForSleepyTest(ITree root) {
        List<ITree> testfunclist = TreeNodeAnalyzer.getTestFunctionList(root);




=======
    public Map<String, Boolean> searchForSleepyTest(ITree root) {
        //System.out.println("root: " + root.toString());
        List<ITree> testfunclist = TreeNodeAnalyzer.getTestFunctionList(root);
>>>>>>> 63cf043761a0e0057ff57ae9d9f2495203e7aa17
        Map<String, Boolean> sleepyAndAfterTest = new HashMap<>();
        ITree classnode = SrcmlUnityCsMetaDataGenerator.breadthFirstSearchForNode(root, "class", "c1");

        if (classnode == null) return sleepyAndAfterTest;

        ITree classname = SrcmlUnityCsMetaDataGenerator.getClassName(classnode);
        String lowerclassname = classname.getLabel();

        for (ITree testfunc : testfunclist) {
            // Search for the 'Thread' class
            List<ITree> threadlist = TreeNodeAnalyzer.getSearchTypeLabel(testfunc, "name", "Thread");
<<<<<<< HEAD
=======
            //System.out.println("thread list"+threadlist);
>>>>>>> 63cf043761a0e0057ff57ae9d9f2495203e7aa17
            // Search for the 'After' method
            List<ITree> afterList = TreeNodeAnalyzer.getSearchTypeLabel(testfunc, "name", "After");

            List<ITree> waitList = TreeNodeAnalyzer.getSearchTypeLabel(testfunc, "name", "WaitForSeconds");

<<<<<<< HEAD

//            System.out.println("SIZEEEEEEEEEEEEE ---> " + threadlist.size() + "-->" + afterList.size() + "-->" + waitList.size());
            ProjectPropertyAnalyzer.writeLog("SIZEEEEEEEEEEEEE ---> " + threadlist.size() + "-->" + afterList.size() + "-->" + waitList.size());
//            for (int i = 0;i<testfunclist.size();i++){
//                System.out.println("TestFunctionListCheck =====>> " + testfunclist.get(i)  + "\n");
//            }

            ITree funcnamenode = SrcmlUnityCsMetaDataGenerator.getFuncName(testfunc);
            String classtestfunc = lowerclassname + Config.separatorStr + funcnamenode.getLabel();

            boolean sleepFound = false;
            boolean afterSecondsFound = false;

            // Check if 'Thread.sleep()' is found
            if (threadlist != null && threadlist.size() > 0) {
                sleepFound = checkThreadSleep(threadlist);
=======
            List<ITree> taskdelaylist = TreeNodeAnalyzer.getSearchTypeLabel(testfunc, "name", "Task");


            ITree funcnamenode = SrcmlUnityCsMetaDataGenerator.getFuncName(testfunc);
            String classtestfunc = lowerclassname + Config.separatorStr + funcnamenode.getLabel();
           // System.out.println("classtestfunc"+classtestfunc);

            boolean sleepFound = false;
            boolean afterSecondsFound = false;
            boolean waitListFound = false;
            boolean taskdelayFound = false;

            // Check if 'Thread.sleep()' is found
            if (threadlist != null && threadlist.size() > 0) {
                String nextseq = "sleep";
                sleepFound = checkSleepTest(threadlist, nextseq);
>>>>>>> 63cf043761a0e0057ff57ae9d9f2495203e7aa17
            }

            // Check if 'After(x).Seconds' is found
            if (afterList != null && afterList.size() > 0) {
                afterSecondsFound = checkAfterSeconds(afterList);
            }
<<<<<<< HEAD

            // Combine both results, if either is found, mark as true
            sleepyAndAfterTest.put(classtestfunc, sleepFound || afterSecondsFound);
=======

            if (waitList != null && waitList.size() > 0) {
                waitListFound = checkWaitforseconds(waitList);
            }

            if (taskdelaylist != null && taskdelaylist.size() > 0) {
                String nextseq = "Delay";
                taskdelayFound = checkSleepTest(taskdelaylist, nextseq);
            }

            // Combine both results, if either is found, mark as true
            sleepyAndAfterTest.put(classtestfunc, sleepFound || afterSecondsFound || waitListFound || taskdelayFound);
>>>>>>> 63cf043761a0e0057ff57ae9d9f2495203e7aa17
        }

        return sleepyAndAfterTest;
    }

<<<<<<< HEAD
    private boolean checkThreadSleep(List<ITree> foundList) {
        boolean isfound = false;

        for (ITree threadNode : foundList) {
            List<ITree> siblings = threadNode.getParent().getChildren();
            for (int i = 0; i < siblings.size(); i++) {
                if (siblings.get(i).equals(threadNode)) {
                    // Check if next sibling is '.' and the one after that is 'sleep'
                    if (i + 2 < siblings.size()) {
                        ITree nextNode = siblings.get(i + 1);
                        ITree sleepNode = siblings.get(i + 2);

                        if (".".equals(nextNode.getLabel()) && "sleep".equals(sleepNode.getLabel())) {
                            isfound = true;
                            break;
=======
//    private boolean checkThreadSleep(List<ITree> foundList) {
//        boolean isfound = false;
//
//        for (ITree threadNode : foundList) {
//            List<ITree> siblings = threadNode.getParent().getChildren();
//            for (int i = 0; i < siblings.size(); i++) {
//                if (siblings.get(i).equals(threadNode)) {
//                    // Check if next sibling is '.' and the one after that is 'sleep'
//                    if (i + 2 < siblings.size()) {
//                        ITree nextNode = siblings.get(i + 1);
//                        ITree sleepNode = siblings.get(i + 2);
//
//                        if (".".equals(nextNode.getLabel()) && "sleep".equals(sleepNode.getLabel())) {
//                            isfound = true;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        return isfound;
//    }

    private boolean checkAfterSeconds(List<ITree> foundList) {
        boolean isfound = false;

        // Traverse through the nodes where 'After' is found
        for (ITree afterNode : foundList) {
            //System.out.println("getting parents:"+ afterNode.getParents().get(0));
            ITree x = afterNode.getParents().get(0);
            ITree y = afterNode.getParents().get(1);
            //System.out.println("getting parents y:"+ afterNode.getParents().get(2));
            //System.out.println("getting children:"+ x.getChildren());
            //System.out.println("getting children:"+ y.getChildren());
            List<ITree> siblings = x.getChildren();
            List<ITree> sib = y.getChildren();
            for (int i = 0; i < siblings.size()-1; i++) {
                //System.out.println("getting sibs:"+ siblings.get(i));
                if (siblings.get(i).equals(afterNode)) {
                    List<ITree> children = y.getChildren();
                    for (int j = 0; j < children.size(); j++){
                        // Check if the next sibling is the argument list and then the '.' operator
                        if (j + 2 < sib.size()) {
                            ITree nextNode = sib.get(j + 1);
                            ITree sleepNode = sib.get(j + 2);
                            if (".".equals(nextNode.getLabel()) && "Seconds".equals(sleepNode.getLabel())) {
                                isfound = true;
                                break;
                            }
>>>>>>> 63cf043761a0e0057ff57ae9d9f2495203e7aa17
                        }
                    }
                }
            }
        }

        return isfound;
    }

<<<<<<< HEAD
    private boolean checkAfterSeconds(List<ITree> foundList) {
        boolean isfound = false;

        // Traverse through the nodes where 'After' is found
        for (ITree afterNode : foundList) {
            List<ITree> siblings = afterNode.getParent().getChildren();
            for (int i = 0; i < siblings.size(); i++) {
                if (siblings.get(i).equals(afterNode)) {
                    // Check if the next sibling is the argument list and then the '.' operator
                    if (i + 2 < siblings.size()) {
                        ITree argumentListNode = siblings.get(i + 1); // The argument list After(4)
                        ITree dotOperatorNode = siblings.get(i + 2);  // The '.' operator

                        // Verify argument list and dot operator are present
                        if (".".equals(dotOperatorNode.getLabel())) {
                            // Check if the next sibling is 'Seconds'
                            if (i + 3 < siblings.size()) {
                                ITree secondsNode = siblings.get(i + 3);
                                if ("Seconds".equals(secondsNode.getLabel())) {
                                    System.out.println("Found After(x).Seconds call");
                                    isfound = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

=======
    private boolean checkWaitforseconds(List<ITree> foundList) {
        boolean isfound = false;
        if (!foundList.isEmpty()) {
            isfound = true;
        }
>>>>>>> 63cf043761a0e0057ff57ae9d9f2495203e7aa17
        return isfound;
    }

    private boolean checkSleepTest(List<ITree> foundList, String nextseq) {
        boolean isfound = false;

        for (ITree threadNode : foundList) {
            List<ITree> siblings = threadNode.getParent().getChildren();
            for (int i = 0; i < siblings.size(); i++) {
                if (siblings.get(i).equals(threadNode)) {
                    // Check if next sibling is '.' and the one after that is 'sleep'
                    if (i + 2 < siblings.size()) {
                        ITree nextNode = siblings.get(i + 1);
                        ITree sleepNode = siblings.get(i + 2);
                        if (".".equals(nextNode.getLabel()) && nextseq.equals(sleepNode.getLabel())) {
                            isfound = true;
                            break;
                        }
                    }
                }
            }
        }

        return isfound;
    }

//    private boolean SleepFound(List<ITree>foundList) {
//        boolean isfound = false;
//
//        for (ITree sleep : foundList) {
//            if(sleep.getLabel().contains("Sleep")) {
//                isfound = true;
//            }
//            else{
//                isfound = false;
//            }
//        }
//        return isfound;
//    }




    public double getSleepyTestStats(Map<String,Boolean> testredundantprintTestmap)
    {

        int total=testredundantprintTestmap.keySet().size();
        if (total == 0)
            return -0.001;

        int redundantPrint=0;

        for(boolean b:testredundantprintTestmap.values()){
            if(b)
                redundantPrint++;
        }

        return  (double) redundantPrint/total;
    }
}