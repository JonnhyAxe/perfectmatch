# Perfectmatch Data Design

The following data should be stored. 


Music [id, Artist, Name, Style, Sample[]] 
Sample [id, Name, TimeStamp, Match[]]
Match [id, Sample, Rule, SampleMatched]



#Design (using MongoDB Design [1]) 

- What is the cardinality of the relationship: 

Music-Sample is “one-to-few” (embedded documents).
Sample-Match is  “one-to-squillions” (for “one-to-squillions”, you should use a “parent-reference” in the document storing the “N” side.)

Music [id, Artist, Name, Style, { Sample [id, Name, TimeStamp]}] 
Match [id, SampleID, Rule, SampleMatchedID]

- Do you need to access the object on the “N” side separately, or only in the context of the parent object?

Music-Sample access is made in the context (embedded documents)
Sample-Match access is made in the context. An Suggestion Engine might require the access the object on the “N” side separately.

- What is the ratio of updates to reads for a particular field?

An important consideration is the following data is only CRUD for Music Entity

Updating a Artist with a new sample does not invalidate the previous matchs. 
The new sample should be processed with the existing matchs.
Replacing (Updating) the Artist samples invalidates all the match processing. 

If there is an 'Suggestion Engine' the suggested matchs should be based on an deep search criteria, 
using the same or different rules, OR from another users matchs (if it is an multi user system).

 

#How to run

C:\dev\tools\MongoDB\Server\3.4\bin>mongod.exe --dbpath C:\dev\tools\MongoDB\data


#References 

[1]https://www.mongodb.com/blog/post/6-rules-of-thumb-for-mongodb-schema-design-part-3?_ga=2.22405307.1804380782.1512305856-2029896114.1510297143