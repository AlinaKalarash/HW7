SELECT 
    project.id,
    (DATEDIFF('MONTH', project.start_date, project.finish_date) * SUM(worker.salary)) AS project_cost
FROM 
    project
JOIN 
    project_worker ON project.id = project_worker.project_id
JOIN 
    worker ON project_worker.worker_id = worker.id
GROUP BY 
    project.id, project.start_date, project.finish_date
ORDER BY 
    project_cost DESC;
