## TC Name:TC1 create one lun under different raid groups

### Description

this case is used for testing one lun generally creation support

### Pre-requisite

need to create raid group on the array

### Steps

1. create one lun,with 10GB ,named lunone under raid0 group on the array
2. create one lun,with 10GB ,named luntwo under raid5 group on the array
3. create one lun,with 10GB ,named lunthree under raid6 group on the array
4. create one lun,with 10GB ,named lunfour under other types raid group on the array
5. observe the task status from task monitor of the array
6. wait for a while,Check the lun status ,including some property,such as uuid,size, name
7. check the lun ownership on which array controller (if array is A/A-A and A/P-C)

### Expected result

1. All the tasks should finish without error ,the lun initialization should finish without error and the lun status should be right
2. All the lun property is right

Estimated time :15 min

## TC Name:TC2 create one large size lun under different raid groups

### Description

this case is used for checking the one large size lun creation support

### Pre-requisite

need to create raid group on the array

### Steps

1. create one lun,with 16TB,named lunone, under raid0 group on the array
2. create one lun,with 16TB,named luntwo, under raid5 group on the array
3. create one lun,with 16TB,named lunthree, under raid6 group on the array
4. create one lun,with 16TB,named lunfour, under other types raid group on the array
5. observe the task status and also monitor the array performance data
6. wait for a while,Check the lun status ,including some property,such as uuid,size, name
7. check the lun ownership on which array controller (if array is A/A-A and A/P-C)

### Expected result

1. All the tasks should finish without error ,the lun initialization should finish without error and the lun status should be right
2. All the lun property is right
3. the array performance should not affected

Estimated time :15 min

## TC Name:TC3 boundary value check for lun size

### Description

this case is used for  boundary value check for lun

### Pre-requisite

need to create raid group on the array

### Steps

1. create one lun,input the size with the smallest size which array support
2. create one lun,input the size with the maximum size which array support
3. create one lun,input the size with minus
4. create one lun,input the size with value beyond the maximum
5. observe the task status from task monitor of the array

### Expected result

1. All the tasks should finish without error,lun status should be right
2. The step 1 and 2 succeed ,the step 3,4 should throw an warning

Estimated time :15 min

## TC Name:TC4 create multiple luns under different raid groups

### Description

this case is used for testing multiple luns creation support

### Pre-requisite

need to create raid group on the array

### Steps

1. create 2 luns,each 1GB ,named volume1 under raid0 group on the array
2. create 100 lun,each 1GB ,named volume2 under raid5 group on the array
3. create 1000 luns,each 1GB ,named volume3 under raid6 group on the array
4. observe the task status  and also monitor the array performance data
5. During the step 3 process,get one existed lun information from array
6. wait for a while,Check the lun status ,including some property,such as uuid,size, name
7. record the task finish time for step 1 and step2 and step3
8. check the lun ownership on which array controller (if array is A/A-A and A/P-C)

### Expected result

1. All the tasks should finish without error ,the lun initialization should finish without error and the lun status should be right
2. All the lun property is right
3. step 1 and step 2 and step 3 finish time should be the same with designing,array CPU ,IO ,Memory etc should not catch the threshold ,the effect should be acceptable
4. for step 5 ,it should not hang ,can response correctly

Estimated time :1 hour

## TC Name:TC5 Resize a lun

### Description

this case is used for checking the lun resizing

### Pre-requisite

N/A

### Steps

1. create one lun,with 10GB ,named volume under raid5 group on the array
2. expand the lun to 100GB
3. expand the lun to maxinum
4. reduce the lun size to 10GB
5. record each task finish time
6. observe the task status from task monitor of the array

### Expected result

1. All the tasks should finish without error,lun status should be right
2. The LUN reducing should throw an error or warning,it is not support
Estimated time :15 min

## TC Name:TC6 Export a lun to a host

### Description

this case is used for checking the lun export

### Pre-requisite

need to prepare different types OS

### Steps

1. create 20 luns,with 10GB on the array
2. export three luns to linux os ,for exam,suse,redhat
3. export three luns to windows os ,for exam 2012R2
4. export three luns to AIX os
5. export three luns to Solaris os
6. observe the task status from task monitor of the array
7. wait for a while ,check the lun status from array
8. after all tasks finish,rescan each type of OS ,and check the lun status from OS

### Expected result

1. All the tasks should finish without error,lun status should be right
2. Lun state should change from un-exported to exported ,also show the hosts name
3. The os can see the lun correctly

Estimated time :15 min

## TC Name:TC7 Un-export a lun to a host

### Description

this case is used for checking the lun un-export

### Pre-requisite

TC5

### Steps

1. un-export one lun from linux os
2. un-export one lun from windows os
3. un-export one lun from AIX,HP-UX os
4. un-export one lun from Solaris os
5. rescan each type of OS ,and check the lun status from OS
6. observe the task status from task monitor of the array
7. wait for a while ,check the lun status from array
8. un-export the remaining luns for each os and ,and repeat step 6-8

### Expected result

1. All the tasks should finish without error,lun status should be right
2. Lun lun state should change from exported to un-exported ,also remove the hosts name
3. The os can remove the lun correctly

Estimated time :15 min

## TC Name:TC8 Retrieve the information of a LUN

### Description

this case is used for checking the lun information

### Pre-requisite

Need one linux os

### Steps

1. create one lun,with 10GB on the array
2. check the lun information with command "volinfo lunid"
3. check the output of the command ,the size should be 10GB,the state should be unexport
4. export this lun to one linux os
5. check the lun state from GUI
6. check the output of the GUI ,it should be "exported"
7. observe the task status from task monitor of the array

### Expected result

1. All the tasks should finish without error,lun status should be right
2. Lun lun state should change change correctly

Estimated time :15 min

## TC Name:TC9 Remove a un-exported LUN

### Description

this case is used for checking the removing of un-exported lun

### Pre-requisite

N/A

### Steps

1. create one lun,with 10GB on the array
2. delete this lun from GUI or command
3. observe the task status from task monitor of the array
4. the lun should be removed,the the lun space should be free
5. create a new lun with the same space ,it shoule succeed

### Expected result

1. All the tasks should finish without error,lun status should be right
2. delete the lun succeed

Estimated time :10 min

## TC Name:TC10 Remove an exported LUN

### Description

this case is used for checking the removing of exported lun

### Pre-requisite

need to prepare one linux os

### Steps

1. create one lun,with 10GB on the array
2. export this lun to one linux os
2. delete this lun from GUI or command
3. it should forbid to delele one lun which has been exported
4. check the lun status ,all should be fine

### Expected result

1. All the tasks should finish without error,lun status should be right
2. delete the lun fail

Estimated time :10 min

## TC Name:TC11 Export many luns to a host

### Description

this case is used for checking many luns export

### Pre-requisite

need to prepare different types OS

### Steps

1. create 500 luns,with 1GB on the array
2. export all the luns to the linux host
3. check the task monitor,and the array monitor,the performance should not be affected
4. During the step 3 process,get one existed lun information from array
5. wait for a while,rescan  OS ,and check the lun status from OS

### Expected result

1. All the tasks should finish without error,lun status should be right
2. Lun state should change from un-exported to exported ,also show the hosts name
3. The os can see the lun correctly
4. array CPU ,IO,Memory etc should not catch  the threshold ,the effect should be acceptable
5. step 4 should not hang,can response correctly

Estimated time :1 hour

## TC Name:TC12 Requests Concurrent support checking

### Description:this case is used for checking array concurrent support

### Pre-requisite

N/A

### Steps

1. create 100 luns,with 10GB on the array
2. export all the luns to the linux host
3. create and format the volumes on these luns from os
4. start a multiple requests from one tool,IO tool or other applications with multithreading
6. check the task and performance monitor from array
7. create one lun during this process
8. wait for a while,check tool status from OS,all should be normal
9. keep the test running for 30 minutes

### Expected result

1. All the tasks should finish without error on array
2. The tool of os not see error

Estimated time :1 hour